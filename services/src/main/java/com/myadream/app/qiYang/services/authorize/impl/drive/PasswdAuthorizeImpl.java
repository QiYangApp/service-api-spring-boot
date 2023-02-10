package com.myadream.app.qiYang.services.authorize.impl.drive;

import cn.hutool.crypto.digest.MD5;
import com.myadream.app.qiYang.entity.dto.QyMemberEntity;
import com.myadream.app.qiYang.entity.dto.QyMemberPasswordEntity;
import com.myadream.app.qiYang.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiYang.entity.pojo.authorize.PasswdLoginPojo;
import com.myadream.app.qiYang.entity.pojo.authorize.RegisterPojo;
import com.myadream.app.qiYang.enums.os.I18nEnum;
import com.myadream.app.qiYang.exception.BizException;
import com.myadream.app.qiYang.repository.MemberPasswdRepository;
import com.myadream.app.qiYang.repository.MemberRepository;
import com.myadream.app.qiYang.services.authorize.AuthorizeService;
import com.myadream.app.qiYang.services.authorize.impl.AuthorizeOperationService;
import com.myadream.app.qiYang.utils.I18nMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 密码登录
 */
public class PasswdAuthorizeImpl implements AuthorizeOperationService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberPasswdRepository memberPasswdRepository;

    @Autowired
    private AuthorizeService authorizeService;

    @Autowired
    private MD5 md5;

    @Override
    public boolean login(LoginPojo loginPojo) throws BizException {
        PasswdLoginPojo passwordLoginPojo = (PasswdLoginPojo) loginPojo;
        if (passwordLoginPojo.getAccount().isEmpty()) {
           throw new BizException(I18nMessageUtil.getMessage(I18nEnum.AUTHORIZE_ACCOUNT_EMPTY));
        }

        if (passwordLoginPojo.getPassword().isEmpty()) {
            throw new BizException(I18nMessageUtil.getMessage(I18nEnum.AUTHORIZE_PASSWORD_EMPTY));
        }

        //根据账号查询会员是否存在
        QyMemberEntity qyMemberEntity = memberRepository.findByEmailOrAccount(passwordLoginPojo.getAccount());
        if (qyMemberEntity == null) {
            throw new BizException(I18nMessageUtil.getMessage(I18nEnum.AUTHORIZE_ACCOUNT_NOT_EXISTS));
        }

        QyMemberPasswordEntity qyMemberPasswordEntity = memberPasswdRepository.findByMemberId((long) qyMemberEntity.getId());
        if (qyMemberPasswordEntity == null) {
            throw new BizException(I18nMessageUtil.getMessage(I18nEnum.STATUS_ERROR));
        }

        //检验密码是否正确
        if (!qyMemberPasswordEntity.getPasswd().equals(this.password(passwordLoginPojo.getPassword(), qyMemberPasswordEntity.getUuid()))) {
            throw new BizException(I18nMessageUtil.getMessage(I18nEnum.AUTHORIZE_PASSWORD_ERROR));
        }

        //进行授权操作
        authorizeService.authorize(qyMemberEntity);

        return true;
    }

    private String password(String password, String uuid)
    {
        return md5.digestHex(this.generatePassword(password) + uuid);
    }

    private String generatePassword(String password)
    {
        return md5.digestHex(password);
    }

    private String generatePasswordSite()
    {
        return UUID.randomUUID().toString();
    }


    @Override
    public boolean register(RegisterPojo registerPojo) {
        return false;
    }
}
