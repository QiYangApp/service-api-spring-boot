package com.myadream.app.qiYang.services.security.config

import cn.hutool.core.collection.CollUtil
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDecisionManager
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.authentication.InsufficientAuthenticationException
import org.springframework.security.core.Authentication

/**
 * 动态权限决策管理器，用于判断用户是否有访问权限
 * Created by macro on 2020/2/7.
 */
class DynamicAccessDecisionManager : AccessDecisionManager {
    @Throws(AccessDeniedException::class, InsufficientAuthenticationException::class)
    override fun decide(
        authentication: Authentication, `object`: Any,
        configAttributes: Collection<ConfigAttribute>
    ) {
        // 当接口未被配置资源时直接放行
        if (CollUtil.isEmpty(configAttributes)) {
            return
        }
        val iterator = configAttributes.iterator()
        while (iterator.hasNext()) {
            val configAttribute = iterator.next()
            //将访问所需资源或用户拥有资源进行比对
            val needAuthority = configAttribute.attribute
            for (grantedAuthority in authentication.authorities) {
                if (needAuthority.trim { it <= ' ' } == grantedAuthority.authority) {
                    return
                }
            }
        }
        throw AccessDeniedException(HttpStatus.UNAUTHORIZED.toString())
    }

    override fun supports(configAttribute: ConfigAttribute): Boolean {
        return true
    }

    override fun supports(aClass: Class<*>?): Boolean {
        return true
    }
}