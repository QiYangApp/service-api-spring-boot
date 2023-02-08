package com.myadream.app.qiYang.controller.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.myadream.app.qiYang.controller.resp.mode.ObjectMode;
import com.myadream.app.qiYang.controller.resp.mode.PageMode;
import com.myadream.app.qiYang.controller.resp.mode.PageStructure;
import com.myadream.app.qiYang.enums.os.StatusEnum;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "message",
        "data",
        "list",
        "page",
        "status",
        "timestamp"
})
@Getter
public class RespEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private final long timestamp = System.currentTimeMillis();

    /**
     * code
     */
    private final Integer code;

    /**
     * 返回状态码
     */
    private final StatusEnum status;

    /**
     * 返回消息
     */
    private final String message;

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
     */
    public RespEntity(ObjectMode mode) {
        super();
        this.code = mode.getCode().value();
        this.status = mode.getStatus();
        this.message = mode.getMessage();
        this.data = mode.getData();
    }

    public RespEntity(PageMode mode) {
        super();
        this.code = mode.getCode().value();
        this.status = mode.getStatus();
        this.message = mode.getMessage();
        this.page = mode.getPage();
        this.list = mode.getList();
    }


    @Override
    public String toString() {
        if (list == null) {
            return "ResultEntity{" +
                    "msg='" + message + '\'' +
                    ", code=" + code +
                    ", data=" + data +
                    ", status=" + status +
                    ", timestamp=" + timestamp +
                    '}';
        } else {
            return "ResultEntity{" +
                    "msg='" + message + '\'' +
                    ", code=" + code +
                    ", list=" + list +
                    ", page=" + page +
                    ", status=" + status +
                    ", timestamp=" + timestamp +
                    '}';
        }

    }

}
