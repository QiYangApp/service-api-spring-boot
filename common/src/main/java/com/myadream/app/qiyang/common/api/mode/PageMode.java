package com.myadream.app.qiyang.common.api.mode;

import lombok.Data;

import java.util.List;

@Data
public class PageMode {

    /**
     * code
     */
    private Integer code;

    /**
     * 返回状态码
     */
    private String status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 分页列表
     */
    private List<Object> list;

    /**
     * 分页信息
     */
    private PageStructure page;
}
