package com.myadream.app.qiyang.service.config.spring.security;

import com.myadream.app.qiyang.service.entity.os.resp.mode.ObjectMode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public LoginAuthenticationEntryPoint() {
        super("/api/user/login");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
//        RestUtil.response(response, SystemCode.UNAUTHORIZED);
//        ObjectMode.success()
    }
}
