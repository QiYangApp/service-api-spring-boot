package com.myadream.app.qiYang.enums.os;

import lombok.Getter;

@Getter
public enum HeaderEnum {

    /**
     * 渠道
     *
     * @var string
     */
    CHANNEL("channel"),

    /**
     * 记录 ipv6
     *
     * @var string
     */
    IPV6("ipv6"),

    /**
     * 记录ipv4
     *
     * @var string
     */
    IPV4("ipv4"),

    /**
     * 版本号
     *
     * @var string
     */
    VERSION("version"),

    /**
     * 请求设备
     *
     * @var string
     */
    DEVICE("device");

    private final String key;

    HeaderEnum(String key) {
        this.key = key;
    }
}
