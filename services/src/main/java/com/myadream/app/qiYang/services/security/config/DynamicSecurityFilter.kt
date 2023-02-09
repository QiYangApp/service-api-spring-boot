package com.myadream.app.qiYang.services.security.config

import com.myadream.app.qiYang.config.property.IgnoreUrlsConfig
import jakarta.servlet.*
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.security.access.SecurityMetadataSource
import org.springframework.security.access.intercept.AbstractSecurityInterceptor
import org.springframework.security.web.FilterInvocation
import org.springframework.util.AntPathMatcher
import org.springframework.util.PathMatcher
import java.io.IOException


/**
 * 动态权限过滤器，用于实现基于路径的动态权限过滤
 * Created by macro on 2020/2/7.
 */
class DynamicSecurityFilter : AbstractSecurityInterceptor(), Filter {
    @Autowired
    private val dynamicSecurityMetadataSource: DynamicSecurityMetadataSource? = null

    @Autowired
    private val ignoreUrlsConfig: IgnoreUrlsConfig? = null

    @Autowired
    fun setMyAccessDecisionManager(dynamicAccessDecisionManager: DynamicAccessDecisionManager?) {
        super.setAccessDecisionManager(dynamicAccessDecisionManager)
    }

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig?) {
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse?, filterChain: FilterChain?) {
        val request: HttpServletRequest = servletRequest as HttpServletRequest
        val fi = FilterInvocation(servletRequest, servletResponse, filterChain)
        //OPTIONS请求直接放行
        if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            fi.chain.doFilter(fi.request, fi.response)
            return
        }
        //白名单请求直接放行
        val pathMatcher: PathMatcher = AntPathMatcher()
        for (path in ignoreUrlsConfig.getUrls()) {
            if (pathMatcher.match(path, request.getRequestURI())) {
                fi.chain.doFilter(fi.request, fi.response)
                return
            }
        }
        //此处会调用AccessDecisionManager中的decide方法进行鉴权操作
        val token = super.beforeInvocation(fi)
        try {
            fi.chain.doFilter(fi.request, fi.response)
        } finally {
            super.afterInvocation(token, null)
        }
    }

    fun destroy() {}
    override fun getSecureObjectClass(): Class<*> {
        return FilterInvocation::class.java
    }

    override fun obtainSecurityMetadataSource(): SecurityMetadataSource {
        return dynamicSecurityMetadataSource
    }
}