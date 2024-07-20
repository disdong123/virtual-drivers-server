package kr.disdong.virtual.drivers.domain.user.model.impl

import kr.disdong.virtual.drivers.domain.user.model.PlainUser

class PlainUserJpaImpl(
    override val id: Long = 0,
    override var name: String,
    override val phone: String
) : PlainUser
