package kr.disdong.virtual.drivers.domain.user.model

interface PlainUser : UserData

interface User : UserData

interface UserData {
    val id: Long
    val name: String
    val phone: String
}
