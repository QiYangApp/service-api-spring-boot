package com.myadream.app.qiYang.services.security.impl

import com.myadream.app.qiYang.entity.dto.QyRoleEntity
import com.myadream.app.qiYang.entity.dto.QyRouterEntity
import com.myadream.app.qiYang.repository.RouterRepository
import com.myadream.app.qiYang.services.authorize.AuthorizeService
import com.myadream.app.qiYang.services.security.DynamicSecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DynamicSecurityServiceImpl : DynamicSecurityService {
//    @Autowired
//    private val routerRepository: RouterRepository =  null;
//
//    @Autowired
//    private val authorizeService: AuthorizeService? = null
    fun getRouteByMemberId(memberId: Long?): Collection<QyRoleEntity> {
//        return routerRepository.getPermissionRoutesByMemberId(memberId)
        return ArrayList();
    }

    val allRoute: Collection<Any>
        get() = ArrayList()
    val currentAuthorizeRoute: Collection<Any> get() {return ArrayList()}
//        get() {
//            val token: String = authorizeService.getCurrentAuthorizeToken() ?: return ArrayList()
//            val authorizedPo: AuthorizedPo = authorizeService.getAuthorizeInfo(token)
//                ?: return ArrayList()
//            return authorizedPo.getRouters()
//        }

    fun getRouteByRuleId(roleId: Long?): Collection<Any> {
//        return routerRepository.getPermissionRoutesByRoleId(roleId)
//        return
        return ArrayList();
    }
}