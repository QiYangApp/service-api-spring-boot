package com.myadream.app.qiyang.common.api.mode;

import com.myadream.app.qiyang.common.api.RespEntity;
import com.myadream.app.qiyang.common.api.StatusEnum;
import com.myadream.app.qiyang.common.utils.I18nMessageUtil;
import com.myadream.app.qiyang.config.enums.I18nEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DefaultMode<T> implements RespMode {
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

    public RespEntity success(T data) {
        return this.resp(data, I18nEnum.STATUS_SUCCESS, HttpStatus.OK, StatusEnum.SUCCESS);
    }

    public RespEntity success(T data, I18nEnum message) {
        return this.resp(data, message, HttpStatus.OK, StatusEnum.SUCCESS);
    }

    public RespEntity success(T data, HttpStatus code) {
        return this.resp(data, I18nEnum.STATUS_SUCCESS, code, StatusEnum.SUCCESS);
    }

    public RespEntity success(T data, HttpStatus code, I18nEnum message) {
        return this.resp(data, message, code, StatusEnum.SUCCESS);
    }

    public RespEntity error(T data) {
        return this.resp(data, I18nEnum.STATUS_ERROR, HttpStatus.BAD_REQUEST, StatusEnum.ERROR);
    }

    public RespEntity error(T data, I18nEnum message) {
        return this.resp(data, message, HttpStatus.BAD_REQUEST, StatusEnum.ERROR);
    }

    public RespEntity error(T data, HttpStatus code) {
        return this.resp(data, I18nEnum.STATUS_ERROR, code, StatusEnum.ERROR);
    }

    public RespEntity error(T data, HttpStatus code, I18nEnum message) {
        return this.resp(data, message, code, StatusEnum.ERROR);
    }

    public RespEntity fail(T throwable) {
        return this.resp(throwable, I18nEnum.STATUS_ABNORMAL, HttpStatus.INTERNAL_SERVER_ERROR, StatusEnum.FAIL);
    }

    public RespEntity fail(T throwable, HttpStatus code, I18nEnum message) {
        return this.resp(throwable, message, code, StatusEnum.FAIL);
    }

    public RespEntity resp(T data, I18nEnum message, HttpStatus code, StatusEnum status) {
        this.data = data;
        this.status = status;
        this.code = code;
        this.message = I18nMessageUtil.getMessage(message.getKey());

        return new RespEntity(this);
    }


}
