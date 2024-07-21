package kr.disdong.virtual.drivers.domain.car.model.impl

import kr.disdong.virtual.drivers.domain.car.model.Car
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.car.model.CarEntity

class CarImpl(
    private val entity: CarEntity,
) : Car {
    override val id: Long
        get() = entity.id
    override val carName: String
        get() = entity.name
    override val carNumber: String
        get() = entity.number
    override val ownerId: Long
        get() = entity.ownerId
}

fun CarEntity.toCar(): Car {
    return CarImpl(entity = this)
}
