package com.myadream.app.qiyang.common.exception;

import com.myadream.app.qiyang.common.api.StatusEnum;

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
