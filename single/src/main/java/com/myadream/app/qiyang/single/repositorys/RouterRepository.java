package com.myadream.app.qiyang.single.repositorys;

import com.myadream.app.qiyang.single.entity.dto.QyRoleEntity;
import com.myadream.app.qiyang.single.entity.dto.QyRouterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface RouterRepository extends JpaRepository<QyRouterEntity, Long> {
    /**
     * 获取当前会员所有路由
     *
     * @param memberId
     * @return Collection<QyRouterEntity>
     */
    @Query(nativeQuery = true, value = "select * from qy_router where id in (select qy_permission_router_relation.router_id from qy_member_role_relation left join qy_role_permission_relation on qy_member_role_relation.role_id = qy_role_permission_relation.role_id left join qy_permission_router_relation on qy_permission_router_relation.permission_group_id = qy_role_permission_relation.permission_group_id where qy_member_role_relation.member_id = ?1)")
    Collection<QyRoleEntity> getPermissionRoutesByMemberId(Long memberId);

    /**
     * 获取当前会员所有路由
     *
     * @param roleId
     * @return Collection<QyRouterEntity>
     */
    @Query(nativeQuery = true, value = "select * from qy_router where id in (select qy_permission_router_relation.router_id from qy_member_role_relation left join qy_role_permission_relation on qy_member_role_relation.role_id = qy_role_permission_relation.role_id left join qy_permission_router_relation on qy_permission_router_relation.permission_group_id = qy_role_permission_relation.permission_group_id where qy_member_role_relation.role_id = ?1)")
    Collection<QyRouterEntity> getPermissionRoutesByRoleId(Long roleId);
}
