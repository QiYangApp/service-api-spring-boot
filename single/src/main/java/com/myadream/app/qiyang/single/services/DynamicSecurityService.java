package com.myadream.app.qiyang.single.services;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> getRouteByRuleId(Long roleId);

    /**
     * 获取所有路由
     */
    Map<String, ConfigAttribute> getRouteByMemberId(Long memberId);

    /**
     * 获取所有路由
     */
    Map<String, ConfigAttribute> getAllRoute();
}
