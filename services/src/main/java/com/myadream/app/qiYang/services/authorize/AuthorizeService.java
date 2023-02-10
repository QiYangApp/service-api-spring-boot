package com.myadream.app.qiYang.services.authorize;


import com.myadream.app.qiYang.entity.dto.QyMemberEntity;
import com.myadream.app.qiYang.entity.po.authorize.AuthorizedPo;

public interface AuthorizeService {

    /**
     * 授权
     */
    boolean authorize(QyMemberEntity qyMemberEntity);

    /**
     * 获取当前授权token
     *
     */
    String getCurrentAuthorizeToken();

    /**
     * 移除授权
     */
    boolean remove(AuthorizedPo authorizedPo);

    /**
     * 检查是否存在
     */
    boolean isExist(AuthorizedPo authorizedPo);

    /**
     * 检查是否存在
     */
    boolean isExist(String token);

    /**
     * 获取授权信息
     */
    AuthorizedPo getAuthorizeInfo(QyMemberEntity qyMemberEntity);

    /**
     * 根据token 获取授权信息
     */
    AuthorizedPo getAuthorizeInfo(String token);
}