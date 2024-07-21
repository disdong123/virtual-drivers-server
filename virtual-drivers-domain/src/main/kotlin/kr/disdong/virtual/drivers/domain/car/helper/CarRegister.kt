package kr.disdong.virtual.drivers.domain.car.helper

import kr.disdong.virtual.drivers.domain.car.model.Car
import kr.disdong.virtual.drivers.domain.car.model.PlainCar
import kr.disdong.virtual.drivers.domain.car.model.impl.CarImpl
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.car.model.CarEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.car.repository.CarJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CarRegister(
    private val carJpaRepository: CarJpaRepository,
) {

    @Transactional
    fun register(car: PlainCar): Car {
        return CarImpl(carJpaRepository.save(toEntity(car)))
    }

    private fun toEntity(car: PlainCar): CarEntity {
        return CarEntity(name = car.carName, number = car.carNumber, ownerId = car.ownerId)
    }
}
