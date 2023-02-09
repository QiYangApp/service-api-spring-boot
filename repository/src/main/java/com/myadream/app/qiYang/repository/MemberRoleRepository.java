package com.myadream.app.qiYang.repository;

import com.myadream.app.qiYang.entity.dto.QyMemberRoleRelationEntity;
import com.myadream.app.qiYang.entity.dto.QyRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @author myadream
 */
public interface MemberRoleRepository extends CrudRepository<QyMemberRoleRelationEntity, Long> {

    /**
     * 查询用户所有角色
     *
     * @param memberId 用户id
     * @return Collection<QyRoleEntity>
     */
    @Query(nativeQuery = true, value = "select * from qy_member_role_relation left join qy_role on qy_member_role_relation.role_id = qy_role.id where qy_member_role_relation.member_id = ?1")
    Collection<QyRoleEntity> getAllByMemberId(Long memberId);
}
