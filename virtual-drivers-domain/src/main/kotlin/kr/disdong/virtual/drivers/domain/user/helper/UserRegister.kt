package kr.disdong.virtual.drivers.domain.user.helper

import kr.disdong.virtual.drivers.domain.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.user.model.User
import kr.disdong.virtual.drivers.domain.user.model.impl.UserImpl
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.user.model.UserEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.user.repository.UserJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserRegister(
    private val userJpaRepository: UserJpaRepository,
) {

    @Transactional
    fun register(user: PlainUser): User {
        return UserImpl(userJpaRepository.save(toEntity(user)))
    }

    private fun toEntity(user: PlainUser): UserEntity {
        return UserEntity(name = user.name, phone = user.phone)
    }
}
