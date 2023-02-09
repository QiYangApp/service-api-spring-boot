package com.myadream.app.qiYang.services.authorize;


import com.myadream.app.qiYang.entity.dto.QyMemberAuthorizeRecordEntity;
import com.myadream.app.qiYang.entity.dto.QyMemberEntity;
import com.myadream.app.qiYang.entity.po.authorize.AuthorizedPo;

import java.util.Collection;

public interface AuthorizeRecordService {

    /**
     * 添加授权记录
     *
     * @param authorizeRecordEntity
     */
    public void addAuthorizeRecord(QyMemberAuthorizeRecordEntity authorizeRecordEntity);

    /**
     *
     * @param authorizedPo 授权信息
     */
    public void authorize(AuthorizedPo authorizedPo);

    /**
     * 获取所有授权记录
     *
     * @param qyMemberEntity 会员信息载体
     */
    public Collection<QyMemberAuthorizeRecordEntity> getAllAuthorize(QyMemberEntity qyMemberEntity);

    /**
     * 获取最后一个登录授权信息
     * @param qyMemberEntity 会员信息载体
     */
    public QyMemberAuthorizeRecordEntity getSingleLastAuthorize(QyMemberEntity qyMemberEntity);
}
