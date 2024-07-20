package kr.disdong.virtual.drivers.domain.user.service

import kr.disdong.virtual.drivers.domain.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.user.model.User
import kr.disdong.virtual.drivers.domain.user.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserManager(
    private val userRepository: UserRepository,
) {
    @Transactional(readOnly = true)
    fun getUser(userId: Long): User? {
        return userRepository.findByUserId(userId)
    }

    @Transactional
    fun create(user: PlainUser): User {
        return userRepository.save(user)
    }
}
