package kr.disdong.springboot.template.server.domain.user.dto

import kr.disdong.springboot.template.domain.user.model.PlainUser
import kr.disdong.springboot.template.domain.user.model.impl.PlainUserJpaImpl

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
