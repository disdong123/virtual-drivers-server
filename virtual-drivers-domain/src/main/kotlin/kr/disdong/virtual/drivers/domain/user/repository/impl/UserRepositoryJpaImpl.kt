package kr.disdong.virtual.drivers.domain.user.repository.impl

import kr.disdong.virtual.drivers.domain.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.user.model.User
import kr.disdong.virtual.drivers.domain.user.model.impl.toUser
import kr.disdong.virtual.drivers.domain.user.repository.UserRepository
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.user.model.UserEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.user.repository.UserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryJpaImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun findByUserId(userId: Long): User? {
        return userJpaRepository.findByUserId(userId)?.toUser()
    }

    override fun save(user: PlainUser): User {
        return userJpaRepository.save(
            UserEntity(
                name = user.name,
                phone = user.phone,
            )
        ).toUser()
    }
}
