package com.myadream.app.qiyang.single.exception;

public class BizException extends BaseException {
    private String message;

    public BizException(String message) {
        this.message = message;
    }
}
    