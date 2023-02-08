package com.myadream.app.qiYang.exception;



import com.myadream.app.qiYang.controller.resp.RespEntity;
import com.myadream.app.qiYang.controller.resp.mode.ObjectMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    private HttpStatus status;

    public BaseException() {
    }

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
