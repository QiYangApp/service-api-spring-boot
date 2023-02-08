package com.myadream.app.qiYang.controller.resp.mode;

import com.myadream.app.qiYang.controller.resp.RespEntity;
import com.myadream.app.qiYang.enums.os.I18nEnum;
import com.myadream.app.qiYang.enums.os.StatusEnum;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public class ObjectMode<T> implements RespMode {
    /**
     * 返回状态码
     */
    private StatusEnum status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回内容
     */
    private T data;

    /**
     * code
     */
    private HttpStatus code;

    public static RespEntity success(Object data) {
        return (new ObjectMode<>()).resp(data, I18nEnum.STATUS_SUCCESS, HttpStatus.OK, StatusEnum.SUCCESS);
    }

    public static RespEntity success(Object data, I18nEnum message) {
        return (new ObjectMode<>()).resp(data, message, HttpStatus.OK, StatusEnum.SUCCESS);
    }

    public static RespEntity success(Object data, HttpStatus code) {
        return (new ObjectMode<>()).resp(data, I18nEnum.STATUS_SUCCESS, code, StatusEnum.SUCCESS);
    }

    public static RespEntity success(Object data, HttpStatus code, I18nEnum message) {
        return (new ObjectMode<>()).resp(data, message, code, StatusEnum.SUCCESS);
    }

    public static RespEntity error(Object data) {
        return (new ObjectMode<>()).resp(data, I18nEnum.STATUS_ERROR, HttpStatus.BAD_REQUEST, StatusEnum.ERROR);
    }

    public static RespEntity error(Object data, I18nEnum message) {
        return (new ObjectMode<>()).resp(data, message, HttpStatus.BAD_REQUEST, StatusEnum.ERROR);
    }

    public static RespEntity error(Object data, HttpStatus code) {
        return (new ObjectMode<>()).resp(data, I18nEnum.STATUS_ERROR, code, StatusEnum.ERROR);
    }

    public static RespEntity error(Object data, HttpStatus code, I18nEnum message) {
        return (new ObjectMode<>()).resp(data, message, code, StatusEnum.ERROR);
    }

    public static RespEntity fail(Throwable throwable) {
        return (new ObjectMode<>()).resp(throwable, I18nEnum.STATUS_ABNORMAL, HttpStatus.INTERNAL_SERVER_ERROR, StatusEnum.FAIL);
    }

    public static RespEntity fail(HttpStatus code, I18nEnum message) {
        return (new ObjectMode<>()).resp("", message, code, StatusEnum.FAIL);
    }

    public static RespEntity fail(Throwable throwable, HttpStatus code, I18nEnum message) {
        return (new ObjectMode<>()).resp(throwable, message, code, StatusEnum.FAIL);
    }

    public RespEntity resp(T data, I18nEnum message, HttpStatus code, StatusEnum status) {
        this.data = data;
        this.status = status;
        this.code = code;
        // todo  111
        this.message = "";// I18nMessageUtil.getMessage(message.getKey());

        return new RespEntity(this);
    }


}
