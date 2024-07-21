package kr.disdong.virtual.drivers.domain.user.model.impl

import kr.disdong.virtual.drivers.domain.user.model.User
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.user.model.UserEntity

class UserImpl(
    private val entity: UserEntity,
) : User {

    override val id: Long
        get() = entity.id
    override val name: String
        get() = entity.name
    override val phone: String
        get() = entity.phone
}
