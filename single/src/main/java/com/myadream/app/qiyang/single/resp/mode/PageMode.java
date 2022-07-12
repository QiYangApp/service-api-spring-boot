package com.myadream.app.qiyang.single.resp.mode;

import com.myadream.app.qiyang.single.resp.StatusEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class PageMode {

    /**
     * code
     */
    private HttpStatus code;

    /**
     * 返回状态码
     */
    private StatusEnum status;

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
