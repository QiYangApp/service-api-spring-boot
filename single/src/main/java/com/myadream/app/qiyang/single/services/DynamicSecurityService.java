package com.myadream.app.qiyang.single.services;

import com.myadream.app.qiyang.single.entity.dto.QyRoleEntity;
import com.myadream.app.qiyang.single.entity.dto.QyRouterEntity;

import java.util.Collection;

public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Collection<QyRouterEntity> getRouteByRuleId(Long roleId);

    /**
     * 获取所有路由
     */
    Collection<QyRoleEntity> getRouteByMemberId(Long memberId);

    /**
     * 获取所有路由
     */
    Collection<QyRouterEntity> getAllRoute();

    /**
     * 获取当前登录会员授权路由
     */
    Collection<QyRouterEntity> getCurrentAuthorizeRoute();

}
