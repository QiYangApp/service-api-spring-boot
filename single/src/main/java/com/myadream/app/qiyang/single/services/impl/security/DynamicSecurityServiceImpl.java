package com.myadream.app.qiyang.single.services.impl.security;

import com.myadream.app.qiyang.single.entity.dto.QyRouterEntity;
import com.myadream.app.qiyang.single.repositorys.MemberPermissionRepository;
import com.myadream.app.qiyang.single.services.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DynamicSecurityServiceImpl implements DynamicSecurityService {

    @Autowired
    private MemberPermissionRepository memberPermissionRepository;

    @Override
    public Map<String, ConfigAttribute> loadDataSource(Long roleId) {
        Collection<QyRouterEntity> routes = memberPermissionRepository.getPermissionRoutesByRoleId(roleId);
        if (routes.isEmpty()) {
            return new HashMap<>(0);
        }

        HashMap<String, ConfigAttribute> configAttributes = new HashMap<>(routes.size());

        routes.forEach(item -> {
            configAttributes.put(, item);
        });

        return routes.stream().map()

        return new HashMap<>(1){{
            put("test", new ConfigAttribute() {
                @Override
                public String getAttribute() {
                    return "test";
                }
            });
        }};
    }
}
