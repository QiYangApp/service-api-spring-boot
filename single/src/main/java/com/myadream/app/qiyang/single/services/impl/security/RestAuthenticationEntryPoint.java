package com.myadream.app.qiyang.single.services.impl.security;

import cn.hutool.json.JSONUtil;
import com.myadream.app.qiyang.single.resp.mode.ObjectMode;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当未登录或者token失效访问接口时，自定义的返回结果
 * Created by macro on 2018/5/14.
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
//                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(ObjectMode.error(authException.getMessage()));

        response.getWriter().println(JSONUtil.parse(ObjectMode.error(authException.getMessage(), HttpStatus.UNAUTHORIZED)));
        response.getWriter().flush();
    }
}