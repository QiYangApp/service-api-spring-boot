package com.myadream.app.qiYang.enums.business;

import lombok.Getter;

/**
 * @author myadream
 */

@Getter
public enum MemberStateEnum {
    /**
     * 会员状态-未激活
     */
    UNACTIVATED("unactivated"),

    /**
     * 会员状态-已激活
     */
    ACTIVATED("activated"),

    /**
     * 会员状态-停用
     */
    DISABLE("disable")
    ;

    private final String state;

    MemberStateEnum(String en) {
       state = en;
    }
}
