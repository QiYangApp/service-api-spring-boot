package com.myadream.app.qiyang.common.api;

public enum StatusEnum {
    /**
     * 成功状态
     *
     * @var string
     */
    SUCCESS("success"),

    /**
     * 失败
     *
     * @var string
     */
    FAIL("fail"),

    /**
     * 错误状态
     *
     * @var string
     */
    ERROR("error");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}

