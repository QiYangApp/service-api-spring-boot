package com.myadream.app.qiyang.service.config.spring.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myadream.app.qiyang.service.annotation.IgnoreCommonResponse;
import com.myadream.app.qiyang.service.entity.os.resp.RespEntity;
import com.myadream.app.qiyang.service.entity.os.resp.mode.ObjectMode;
import com.myadream.app.qiyang.service.exception.BizException;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Type;
import java.util.Objects;


/**
 * @author myadream
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        Type type = returnType.getGenericParameterType();
        // 是否有IgnoreCommonResponse 注解
        boolean isIgnore = Objects.requireNonNull(returnType.getMethod()).getAnnotation(IgnoreCommonResponse.class) != null;
        // 是否是 RestController
        boolean isRestController = returnType.getDeclaringClass().getAnnotation(RestController.class) != null;
        // 是否是 adminJsonController
        boolean isViewJSONController = returnType.getMethod().getAnnotation(ResponseBody.class) != null;

        // 不进行包装的
        boolean noAware = RespEntity.class.equals(type) || isIgnore || !isRestController || isViewJSONController;
        return !noAware;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        Type type = returnType.getGenericParameterType();
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
    