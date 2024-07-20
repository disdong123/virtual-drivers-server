package kr.disdong.springboot.template.domain.user.model.impl

import kr.disdong.springboot.template.domain.user.model.User
import kr.disdong.springboot.template.jpa.domain.user.model.UserEntity

class UserJpaImpl(
    private val entity: UserEntity,
) : User {

    override val id: Long
        get() = entity.id
    override var name: String = entity.name
        get() = entity.name
    override val phone: String
        get() = entity.phone

    override fun updateName(name: String) {
        entity.name = name
    }
}

fun UserEntity.toUser(): User {
    return UserJpaImpl(this)
}
