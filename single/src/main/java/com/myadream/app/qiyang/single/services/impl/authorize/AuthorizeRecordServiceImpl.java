package com.myadream.app.qiyang.single.services.impl.authorize;

import com.myadream.app.qiyang.single.entity.dto.QyMemberAuthorizeRecordEntity;
import com.myadream.app.qiyang.single.entity.dto.QyMemberEntity;
import com.myadream.app.qiyang.single.entity.po.authorize.AuthorizedPo;
import com.myadream.app.qiyang.single.repositorys.MemberAuthorizeRecordRepository;
import com.myadream.app.qiyang.single.services.AuthorizeRecordService;
import com.myadream.app.qiyang.single.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Service
public class AuthorizeRecordServiceImpl implements AuthorizeRecordService {

    @Autowired
    private MemberAuthorizeRecordRepository authorizeRecordRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void addAuthorizeRecord(QyMemberAuthorizeRecordEntity authorizeRecordEntity) {
        authorizeRecordEntity.setCreatedAt(DateTimeUtil.getCurrentTimestamp());
        this.authorizeRecordRepository.save(authorizeRecordEntity);
    }

    @Override
    public void authorize(AuthorizedPo authorizedPo) {
        QyMemberAuthorizeRecordEntity qyMemberAuthorizeRecord = new QyMemberAuthorizeRecordEntity();
        qyMemberAuthorizeRecord.setChannel("");
        qyMemberAuthorizeRecord.setDevice(request.getHeader());
        qyMemberAuthorizeRecord.setMemberId(authorizedPo.getQyMemberEntity().getId());
        qyMemberAuthorizeRecord.setCreatedAt(DateTimeUtil.getCurrentTimestamp());
        qyMemberAuthorizeRecord.setIpv4(request.getRemoteAddr());
        qyMemberAuthorizeRecord.setIpv6("");
        qyMemberAuthorizeRecord.setDeviceDetail("");
        qyMemberAuthorizeRecord.setSnapshot("");

        this.addAuthorizeRecord(qyMemberAuthorizeRecord);
    }

    @Override
    public Collection<QyMemberAuthorizeRecordEntity> getAllAuthorize(QyMemberEntity qyMemberEntity) {
        return null;
    }

    @Override
    public QyMemberAuthorizeRecordEntity getSingleLastAuthorize(QyMemberEntity qyMemberEntity) {
        return null;
    }
}
