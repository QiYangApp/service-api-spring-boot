package com.myadream.app.qiYang.repository;

import com.myadream.app.qiYang.entity.dto.QyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<QyMemberEntity, Long> {
    QyMemberEntity findByEmailOrAccount(String email);

}
