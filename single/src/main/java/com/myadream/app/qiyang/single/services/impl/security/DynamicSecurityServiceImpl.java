package com.myadream.app.qiyang.single.services.impl.security;

import com.myadream.app.qiyang.single.services.DynamicSecurityService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DynamicSecurityServiceImpl implements DynamicSecurityService {
    @Override
    public Map<String, ConfigAttribute> loadDataSource() {
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
