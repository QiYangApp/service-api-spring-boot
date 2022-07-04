package com.myadream.app.qiyang.service.exception;

import com.myadream.app.qiyang.service.entity.os.resp.StatusEnum;

public class BaseException extends RuntimeException {
   private Integer code;

    /**
     * @var string
     */
   private String message;

    /**
     * @var
     */
   private StatusEnum status;
}
