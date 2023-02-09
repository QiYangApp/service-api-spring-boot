package com.myadream.app.qiYang.services.security.config

import cn.hutool.json.JSONUtil
import com.myadream.app.qiYang.controller.resp.mode.ObjectMode
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import java.io.IOException

/**
 * 当未登录或者token失效访问接口时，自定义的返回结果
 * Created by macro on 2018/5/14.
 */
class RestAuthenticationEntryPoint : AuthenticationEntryPoint {
    @Throws(IOException::class, ServletException::class)
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        response.setCharacterEncoding("UTF-8")
        response.setContentType("application/json")
        //                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(ObjectMode.error(authException.getMessage()));
        response.getWriter().println(JSONUtil.parse(ObjectMode.error(authException.message, HttpStatus.UNAUTHORIZED)))
        response.getWriter().flush()
    }
}