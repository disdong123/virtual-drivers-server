package kr.disdong.virtual.drivers.domain.car.model

interface PlainCar : CarData

interface Car : CarData

interface CarData {
    val id: Long
    val carName: String
    val carNumber: String
    val ownerId: Long
}
