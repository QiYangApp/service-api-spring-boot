package com.myadream.app.qiyang.single.repositorys;

import com.myadream.app.qiyang.single.entity.dto.QyMemberPasswordEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberPasswdRepository extends CrudRepository<QyMemberPasswordEntity, Long> {
    QyMemberPasswordEntity findByMemberId(Long memberId);
}
