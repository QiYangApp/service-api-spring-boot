package com.myadream.app.qiyang.single.services.impl.security;

import com.myadream.app.qiyang.single.entity.dto.QyRouterEntity;
import com.myadream.app.qiyang.single.services.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 动态权限数据源，用于获取动态权限规则
 * Created by macro on 2020/2/7.
 */
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return format(dynamicSecurityService.getCurrentAuthorizeRoute());
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return format(dynamicSecurityService.getAllRoute());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 格式化路由
     *
     * @param routes 路由
     */
    private Collection<ConfigAttribute> format(Collection<QyRouterEntity> routes) {
        List<ConfigAttribute> configAttributes = new ArrayList<>();

        //添加当前登录用户授权可访问路由
        for (QyRouterEntity qyRouterEntity : routes) {
            configAttributes.add(
                    new SecurityConfig(qyRouterEntity.getRoute())
            );
        }

        // 未设置操作请求权限，返回空集合
        return configAttributes;
    }
}