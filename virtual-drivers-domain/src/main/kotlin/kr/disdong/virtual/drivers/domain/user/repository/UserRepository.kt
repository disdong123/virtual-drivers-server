package kr.disdong.virtual.drivers.domain.user.repository

import kr.disdong.virtual.drivers.domain.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.user.model.User

interface UserRepository {

    fun findByUserId(userId: Long): User?

    fun save(user: PlainUser): User
}
