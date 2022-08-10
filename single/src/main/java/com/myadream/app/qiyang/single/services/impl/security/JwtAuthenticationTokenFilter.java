package com.myadream.app.qiyang.single.services.impl.security;


import com.myadream.app.qiyang.single.entity.po.authorize.AuthorizedPo;
import com.myadream.app.qiyang.single.services.AuthorizeService;
import com.myadream.app.qiyang.single.services.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 * Created by macro on 2018/4/26.
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthorizeService authorizeService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && SecurityContextHolder.getContext().getAuthentication() == null && !authorizeService.isExist(authHeader)) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(authHeader);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

//            AuthorizedPo authorizedPo = authorizeService.getAuthorizeInfo(authHeader);
//            log.info("authenticated user:{}", authorizedPo);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}