package kr.disdong.virtual.drivers.server.domain.user.service

import kr.disdong.virtual.drivers.domain.user.model.User
import kr.disdong.virtual.drivers.domain.user.service.UserManager
import kr.disdong.virtual.drivers.server.domain.user.dto.CreateUserBody
import kr.disdong.virtual.drivers.server.domain.user.exception.UserNotFound
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userManager: UserManager,
) {

    fun getByUserId(userId: Long) =
        userManager.getUser(userId)
            ?: throw UserNotFound(userId)

    fun create(request: CreateUserBody): User {
        return userManager.create(request.toUser())
    }
}
