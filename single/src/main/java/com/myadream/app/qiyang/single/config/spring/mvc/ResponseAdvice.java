package com.myadream.app.qiyang.single.config.spring.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myadream.app.qiyang.annotation.IgnoreCommonResponse;
import com.myadream.app.qiyang.single.exception.BizException;
import com.myadream.app.qiyang.single.services.impl.resp.RespEntity;
import com.myadream.app.qiyang.single.services.impl.resp.mode.ObjectMode;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;


/**
 * @author myadream
 */
//@RestControllerAdvice(value = "com.myadream.app.qiyang.single.controller")
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        Type type = returnType.getGenericParameterType();
        // 是否有IgnoreCommonResponse 注解
        boolean isIgnore = Objects.requireNonNull(returnType.getMethod()).getAnnotation(IgnoreCommonResponse.class) != null;
        // 是否是 RestController
        boolean isRestController = returnType.getDeclaringClass().getAnnotation(RestController.class) != null;

        // 是否是 RestController
        boolean isSwaggerJson = Json.class.equals(type);

        // 不进行包装的
        boolean noAware = RespEntity.class.equals(type) || isIgnore || !isRestController || isSwaggerJson;
        return !noAware;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        Type type = returnType.getGenericParameterType();

        // 这里需要过滤掉swagger的相关返回
        if (body instanceof Json || body instanceof UiConfiguration || (body instanceof ArrayList && ((ArrayList) body).get(0) instanceof SwaggerResource)) {
            return body;
        }

        if (RespEntity.class.equals(type)) {
            return body;
        } else if (body instanceof String) {
            try {
                return (new ObjectMapper()).writeValueAsString(ObjectMode.success(body));
            } catch (JsonProcessingException e) {
                throw new BizException(e.getMessage());
            }
        } else {
            return ObjectMode.success(body);
        }
    }
}
    