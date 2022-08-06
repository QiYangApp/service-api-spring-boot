package com.myadream.app.qiyang.single.services.impl.security;

import com.myadream.app.qiyang.single.entity.dto.QyRoleEntity;
import com.myadream.app.qiyang.single.entity.dto.QyRouterEntity;
import com.myadream.app.qiyang.single.entity.po.authorize.AuthorizedPo;
import com.myadream.app.qiyang.single.repositorys.RouterRepository;
import com.myadream.app.qiyang.single.services.AuthorizeService;
import com.myadream.app.qiyang.single.services.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DynamicSecurityServiceImpl implements DynamicSecurityService {

    @Autowired
    private RouterRepository routerRepository;

    @Autowired
    private AuthorizeService authorizeService;

    public Collection<QyRoleEntity> getRouteByMemberId(Long memberId) {
        return routerRepository.getPermissionRoutesByMemberId(memberId);
    }

    public Collection<QyRouterEntity> getAllRoute() {
        return routerRepository.findAll();
    }

    @Override
    public Collection<QyRouterEntity> getCurrentAuthorizeRoute() {
        String token = authorizeService.getCurrentAuthorizeToken();
        if (token == null) {
            return new ArrayList<>();
        }
        AuthorizedPo authorizedPo = authorizeService.getAuthorizeInfo(token);
        if (authorizedPo == null) {
            return new ArrayList<>();
        }

        return authorizedPo.getRouters();
    }

    @Override
    public Collection<QyRouterEntity> getRouteByRuleId(Long roleId) {
        return routerRepository.getPermissionRoutesByRoleId(roleId);
    }
}
