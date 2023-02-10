package com.myadream.app.qiYang.services.security.config

import com.myadream.app.qiYang.entity.dto.QyRouterEntity
import com.myadream.app.qiYang.services.security.DynamicSecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.access.SecurityConfig
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource
import org.springframework.stereotype.Component

/**
 * 动态权限数据源，用于获取动态权限规则
 * Created by macro on 2020/2/7.
 */
class DynamicSecurityMetadataSource : FilterInvocationSecurityMetadataSource {
    @Autowired
    private val dynamicSecurityService: DynamicSecurityService? = null

    @Throws(IllegalArgumentException::class)
    override fun getAttributes(o: Any): Collection<ConfigAttribute> {
        return format(ArrayList())
    }

    override fun getAllConfigAttributes(): Collection<ConfigAttribute> {
        return format(ArrayList())
    }

    override fun supports(aClass: Class<*>?): Boolean {
        return true
    }

    /**
     * 格式化路由
     *
     * @param routes 路由
     */
    private fun format(routes: Collection<QyRouterEntity>): Collection<ConfigAttribute> {
        val configAttributes: MutableList<ConfigAttribute> = ArrayList()

        //添加当前登录用户授权可访问路由
        for (qyRouterEntity in routes) {
            configAttributes.add(
                SecurityConfig(qyRouterEntity.getRoute())
            )
        }

        // 未设置操作请求权限，返回空集合
        return configAttributes
    }
}