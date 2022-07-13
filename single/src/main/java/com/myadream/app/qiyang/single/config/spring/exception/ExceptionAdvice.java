package com.myadream.app.qiyang.single.config.spring.exception;

import com.myadream.app.qiyang.single.enums.os.I18nEnum;
import com.myadream.app.qiyang.single.exception.BizException;
import com.myadream.app.qiyang.single.exception.ParamValidException;
import com.myadream.app.qiyang.single.services.impl.resp.RespEntity;
import com.myadream.app.qiyang.single.services.impl.resp.mode.ObjectMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JG.Hannibal
 * @since 2018/7/5 16:07
 */
@RestController
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    /**
     * Hibernate-Validator 异常处理
     * ExceptionHandler 配置异常处理
     * ResponseStatus 配置响应码
     */
    @ExceptionHandler(ParamValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RespEntity paramValidExceptionHandler(ParamValidException ex) {
        return ObjectMode.fail(ex, HttpStatus.NOT_ACCEPTABLE, I18nEnum.STATUS_ABNORMAL);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RespEntity bindExceptionHandler(BindException ex) {
        return paramValidExceptionHandler(new ParamValidException(ex));
    }

    public RespEntity notFoundExceptionHandle(NoHandlerFoundException throwable) {
        return ObjectMode.fail(HttpStatus.NOT_FOUND, I18nEnum.HTTP_NOT_FOUND);
    }

    @ExceptionHandler(UndeclaredThrowableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RespEntity undeclaredThrowableException(UndeclaredThrowableException ex) throws Exception {
        // 获得实际异常
        Throwable throwable = ex.getUndeclaredThrowable();
        // 如果是我们自定义异常就调用自定义异常的处理方法
        if (throwable instanceof ParamValidException) {
            return paramValidExceptionHandler((ParamValidException) throwable);
        }

        return exception(ex);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    private RespEntity handlerNullPointException(NullPointerException ex) throws Exception {
        return exception(ex);
    }


    @ExceptionHandler(BizException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RespEntity appThrowableException(BizException ex) {
        return ObjectMode.fail(ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public RespEntity exception(Exception ex) throws Exception {
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
            throw ex;
        }

        //请求不存在接口
        if (ex instanceof NoHandlerFoundException) {
            return notFoundExceptionHandle((NoHandlerFoundException) ex);
        }

        // 原始错误集合数据偏多，包含native错误
        final StackTraceElement[] stackTrace = ex.getStackTrace();
        // 过滤错误信息
        final List<StackTraceElement> filters = new LinkedList<>();
        for (StackTraceElement st : stackTrace) {
            if (st.getClassName().contains("logictech.")) {
                assert st.getFileName() != null;
                if (st.getFileName().contains(".java")) {
                    filters.add(st);
                }
            }
        }
        StackTraceElement[] stackTraceElements = new StackTraceElement[filters.size()];
        // 计数器
        int i = 0;
        for (StackTraceElement filter : filters) {
            stackTraceElements[i++] = filter;
        }
        // 填充stackTrace
        ex.setStackTrace(stackTraceElements);
        ex.printStackTrace();
        log.error(ex.getMessage(), ex);

        //"发生未知错误, 请联系管理员",
//        return (new DefaultMode<HashMap<String, String>>()).fail( new HashMap() {{
//            put("ex", ex.getClass().getName());
//            put("orgEXMessage", ex.getMessage());
//            put("clazz", stackTraceElements.length == 0 ? null : stackTraceElements[0].getClassName());
//            put("method", stackTraceElements.length == 0 ? null : stackTraceElements[0].getMethodName());
//            put("lineNumber", stackTraceElements.length == 0 ? null : stackTraceElements[0].getLineNumber());
//        }});

        return ObjectMode.fail(ex);
    }
}
    