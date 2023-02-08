package com.myadream.app.qiYang.controller.resp.mode;

import lombok.Data;

@Data
public class PageStructure {
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 页记录数
     */
    private Integer pageSize;
}
