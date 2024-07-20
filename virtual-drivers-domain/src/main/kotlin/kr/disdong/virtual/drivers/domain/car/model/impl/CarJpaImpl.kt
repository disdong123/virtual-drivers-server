package kr.disdong.virtual.drivers.domain.car.model.impl

import kr.disdong.virtual.drivers.domain.car.model.Car
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.car.model.CarEntity

class CarJpaImpl(
    private val entity: CarEntity,
) : Car {
    override val id: Long
        get() = entity.id
    override val carName: String
        get() = entity.carName
    override val carNumber: String
        get() = entity.carNumber
    override val ownerId: Long
        get() = entity.ownerId
}
