package com.myadream.app.qiyang.service.exception;

import com.myadream.app.qiyang.service.entity.os.resp.RespEntity;
import com.myadream.app.qiyang.service.entity.os.resp.StatusEnum;
import com.myadream.app.qiyang.service.entity.os.resp.mode.ObjectMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
public class BaseException extends RuntimeException {
    private Integer code;

    /**
     * @var string
     */
    private String message;

    /**
     * @var
     */
    private StatusEnum status;

    /**
     * 统一 json 异常处理
     *
     * @param exception JsonException
     * @return 统一返回 json 格式
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public RespEntity jsonErrorHandler(BaseException exception) {
        log.error("【JsonException】:{}", exception.getMessage());
        return ObjectMode.success(exception);
    }
}
