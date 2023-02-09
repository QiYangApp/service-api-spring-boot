package com.myadream.app.qiYang.services.authorize.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthorizeService authorizeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("认证请求: " + username);

        AuthorizedPo authorized = authorizeService.getAuthorizeInfo(username);
        if (authorized == null) {
            return null;
        }

        String roles = authorized.getRoles().stream().map(QyRoleEntity::getRoleName).collect(Collectors.joining(","));
        return new User(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(roles));
    }
}
