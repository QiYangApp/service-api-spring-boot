package com.myadream.app.qiyang.single.repositorys;

import com.myadream.app.qiyang.single.entity.dto.QyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<QyMemberEntity, Long> {
    QyMemberEntity findByEmailOrAccount(String email);

}
