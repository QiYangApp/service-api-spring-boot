package com.myadream.app.qiyang.single.enums.os;

public enum HeaderEnum {
    /**
     * 请求设备
     *
     * @var string
     */
    DEVICE("device");

    private String key;

    HeaderEnum(String key) {
        this.key = key;
    }
}
