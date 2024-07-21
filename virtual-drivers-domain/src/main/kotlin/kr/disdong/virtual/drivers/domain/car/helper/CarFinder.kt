package kr.disdong.virtual.drivers.domain.car.helper

import kr.disdong.virtual.drivers.domain.car.model.Car
import kr.disdong.virtual.drivers.domain.car.model.impl.toCar
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.car.repository.CarJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class CarFinder(
    private val carJpaRepository: CarJpaRepository,
) {
    fun findAll(): List<Car> {
        return carJpaRepository.findAll().map { it.toCar() }
    }
}
