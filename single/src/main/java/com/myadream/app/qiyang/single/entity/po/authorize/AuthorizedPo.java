package com.myadream.app.qiyang.single.entity.po.authorize;

import com.myadream.app.qiyang.single.entity.dto.QyMemberEntity;
import com.myadream.app.qiyang.single.entity.dto.QyRoleEntity;
import com.myadream.app.qiyang.single.entity.dto.QyRouterEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class AuthorizedPo {
    private String token;

    /**
     * 用户信息
     */
    private QyMemberEntity qyMemberEntity;

    /**
     * 授权路由
     */
    private Collection<QyRouterEntity> routers;

    /**
     * 权限
     */
    private Collection<QyRoleEntity> roles;
}
