package kr.disdong.virtual.drivers.server.domain.user.dto

import kr.disdong.virtual.drivers.domain.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.user.model.impl.PlainUserJpaImpl

class CreateUserBody(
    val name: String,
    val phone: String,
) {

    fun toUser(): PlainUser {
        return PlainUserJpaImpl(
            name = name,
            phone = phone,
        )
    }
}
