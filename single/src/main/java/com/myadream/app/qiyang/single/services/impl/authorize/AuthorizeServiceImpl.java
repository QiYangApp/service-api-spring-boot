package com.myadream.app.qiyang.single.services.impl.authorize;

import com.myadream.app.qiyang.single.entity.dto.QyMemberEntity;
import com.myadream.app.qiyang.single.entity.po.authorize.AuthorizedPo;
import com.myadream.app.qiyang.single.enums.business.MemberStateEnum;
import com.myadream.app.qiyang.single.repositorys.MemberRoleRepository;
import com.myadream.app.qiyang.single.repositorys.RouterRepository;
import com.myadream.app.qiyang.single.services.AuthorizeService;
import com.myadream.app.qiyang.single.services.JwtService;
import com.myadream.app.qiyang.single.services.impl.token.JwtDataSetImpl;
import com.myadream.app.qiyang.single.utils.RedisUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author myadream
 */
@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    private final JwtService jwtService;

    private final RouterRepository routerRepository;

    private final MemberRoleRepository memberRoleRepository;

    private final RedisUtil redisUtil;

    public AuthorizeServiceImpl(JwtService jwtService, RouterRepository routerRepository, MemberRoleRepository memberRoleRepository, RedisUtil redisUtil) {
        this.jwtService = jwtService;
        this.routerRepository = routerRepository;
        this.memberRoleRepository = memberRoleRepository;
        this.redisUtil = redisUtil;
    }

    @Override
    public boolean authorize(QyMemberEntity qyMemberEntity) {
        if (qyMemberEntity.getId() == 0) {
            return false;
        }

        //不是已激活情况下不允许登录
        if (!Objects.equals(qyMemberEntity.getState(), MemberStateEnum.ACTIVATED.getState())) {
            return false;
        }

        AuthorizedPo authorizedPo = new AuthorizedPo();
        authorizedPo.setQyMemberEntity(qyMemberEntity);
        authorizedPo.setRoles(routerRepository.getPermissionRoutesByMemberId((long) qyMemberEntity.getId()));
        authorizedPo.setRoles(memberRoleRepository.getAllByMemberId((long) qyMemberEntity.getId()));

        authorizedPo = jwtAuthorize(authorizedPo);

        //二次记录token 放在后续通过会员查询或操作缓存信息
        redisUtil.set(generateMemberWithCacheKey(qyMemberEntity), authorizedPo.getToken());

        return true;
    }

    /**
     * 获取会员关联 cache token
     *
     * @param qyMemberEntity 会员信息
     */
    protected String generateMemberWithCacheKey(QyMemberEntity qyMemberEntity) {
        return "member:with:token:" + qyMemberEntity.getId();
    }

    /**
     * 记录 授权信息
     *
     * @param authorizedPo 授权信息
     */
    protected AuthorizedPo jwtAuthorize(AuthorizedPo authorizedPo) {
        //初次生成记录数据
        HashMap<String, Object> data = new HashMap<>(1);
        data.put(authorizedPo.getClass().toString(), authorizedPo);

        String token = jwtService.generate(new JwtDataSetImpl(data));

        //回写token 记录
        authorizedPo.setToken(token);
        data.remove(authorizedPo.getClass().toString());
        data.put(authorizedPo.getClass().toString(), authorizedPo);
        jwtService.update(token, new JwtDataSetImpl(data));

        return authorizedPo;
    }

    @Override
    public boolean remove(AuthorizedPo authorizedPo) {
        redisUtil.del(generateMemberWithCacheKey(authorizedPo.getQyMemberEntity()));
        return jwtService.remove(authorizedPo.getToken());
    }

    @Override
    public boolean isExist(AuthorizedPo authorizedPo) {
        return jwtService.exist(authorizedPo.getToken());
    }

    @Override
    public AuthorizedPo getAuthorizeInfo(QyMemberEntity qyMemberEntity) {
        String token = (String) redisUtil.get(generateMemberWithCacheKey(qyMemberEntity));
        if ("".equals(token)) {
            return null;
        }

        return getAuthorizeInfo(token);
    }

    @Override
    public AuthorizedPo getAuthorizeInfo(String token) {
        return (AuthorizedPo) jwtService.get(token);
    }
}
