package kr.disdong.springboot.template.server.domain.user.service

import kr.disdong.springboot.template.domain.user.model.User
import kr.disdong.springboot.template.domain.user.service.UserManager
import kr.disdong.springboot.template.server.domain.user.dto.CreateUserBody
import kr.disdong.springboot.template.server.domain.user.exception.UserNotFound
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
