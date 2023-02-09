package com.myadream.app.qiYang.services.security.config


import cn.hutool.json.JSONUtil
import com.myadream.app.qiYang.controller.resp.mode.ObjectMode
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import java.io.IOException


/**
 * 当访问接口没有权限时，自定义的返回结果
 * Created by macro on 2018/4/26.
 */
class RestfulAccessDeniedHandler : AccessDeniedHandler {
    @Throws(IOException::class, ServletException::class)
    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        e: AccessDeniedException
    ) {
        response.setCharacterEncoding("UTF-8")
        response.setContentType("application/json")
        response.getWriter().println(JSONUtil.parse(ObjectMode.error(e.message, HttpStatus.ACCEPTED)))
        response.getWriter().flush()
    }
}
