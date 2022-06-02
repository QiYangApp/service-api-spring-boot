package com.myadream.app.qiyang.common.api.mode;

import lombok.Data;

@Data
public class DefaultMode implements RespMode {
    /**
     * 返回状态码
     */
    private String status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回内容
     */
    private Object data;

    /**
     * code
     */
    private Integer code;


}
