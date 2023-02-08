package com.myadream.app.qiYang.enums.os;

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
    STATUS_SUCCESS("default.status.success"),

    /**
     * 状态-失败
     */
    STATUS_ERROR("default.status.error"),

    /**
     * 状态-处理异常
     */
    STATUS_ABNORMAL("default.status.abnormal"),

    /**
     * http-资源不存在
     */
    HTTP_NOT_FOUND("default.http.not_found"),

    /**
     * 名称为空
     */
    AUTHORIZE_NICKNAME_EMPTY("authorize.nickname.empty"),

    /**
     * 账号为空
     */
    AUTHORIZE_ACCOUNT_EMPTY("authorize.account.empty"),
    AUTHORIZE_ACCOUNT_NOT_EXISTS("authorize.account.notExist"),


    /**
     * 密码为空
     */
    AUTHORIZE_PASSWORD_EMPTY("authorize.password.empty"),
    AUTHORIZE_PASSWORD_ERROR("authorize.password.error")
    ;


    private final String key;

    I18nEnum(String s) {
        this.key = s;
    }
}
