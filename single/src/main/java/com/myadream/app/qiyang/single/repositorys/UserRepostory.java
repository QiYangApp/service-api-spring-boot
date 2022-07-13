package com.myadream.app.qiyang.single.repositorys;

import com.myadream.app.qiyang.single.repositorys.dto.QyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostory extends JpaRepository<QyMemberEntity, Long> {
}
