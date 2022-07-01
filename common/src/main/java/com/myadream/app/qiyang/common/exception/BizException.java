package com.myadream.app.qiyang.common.exception;

public class BizException extends BaseException {
    private String message;

    public BizException(String message) {
        this.message = message;
    }
}
    