package com.myadream.app.qiYang.repository;

import com.myadream.app.qiYang.entity.dto.QyMemberPasswordEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberPasswdRepository extends CrudRepository<QyMemberPasswordEntity, Long> {
    QyMemberPasswordEntity findByMemberId(Long memberId);
}
