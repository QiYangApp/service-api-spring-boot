package com.myadream.app.qiyang.service.enums.os;

import lombok.Getter;

/**
 * 国际常量
 *
 * @author myadream
 */
@Getter
public enum I18nEnum {


    /**
     * 状态-成功
     */
    STATUS_SUCCESS("i18n.status.success"),

    /**
     * 状态-失败
     */
    STATUS_ERROR("i18n.status.error"),

    /**
     * 状态-处理异常
     */
    STATUS_ABNORMAL("i18n.status.abnormal");


    private final String key;

    I18nEnum(String s) {
        this.key = s;
    }
}
