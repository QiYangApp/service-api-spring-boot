package com.myadream.app.qiyang.common.api;

import com.myadream.app.qiyang.common.api.mode.DefaultMode;
import com.myadream.app.qiyang.common.api.mode.PageMode;
import com.myadream.app.qiyang.common.api.mode.PageStructure;

import java.util.List;

public class Resp {
    private static final long serialVersionUID = 1L;

    private long timestamp;

    /**
     * code
     */
    private Integer code;

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
    private Object data;

    /**
     * 分页列表
     */
    private List<Object> list;

    /**
     * 分页信息
     */
    private PageStructure page;

    /**
     * 默认格式
     *
     * @return Resp
     */
    public Resp mode(DefaultMode mode) {
        this.code = mode.getCode();
        this.status = mode.getStatus();
        this.message = mode.getMessage();
        this.data = mode.getData();

        return this;
    }

    public Resp mode(PageMode mode) {
        this.code = mode.getCode();
        this.status = mode.getStatus();
        this.message = mode.getMessage();
        this.page = mode.getPage();
        this.list = mode.getList();

        return this;
    }


}
