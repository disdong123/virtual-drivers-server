package kr.disdong.virtual.drivers.domain.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.DrivingDirectionImpl
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.DrivingDirectionRouteImpl
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.DrivingDirectionEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.DrivingDirectionRouteEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.RouteKey
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.repository.DrivingDirectionJpaRepository
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.repository.DrivingDirectionRouteJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DrivingDirectionRegister(
    private val drivingDirectionJpaRepository: DrivingDirectionJpaRepository,
    private val drivingDirectionRouteJpaRepository: DrivingDirectionRouteJpaRepository,
) {

    @Transactional
    fun register(direction: PlainDrivingDirection): DrivingDirection {
        return DrivingDirectionImpl(drivingDirectionJpaRepository.save(toEntity(direction)))
    }

    @Transactional
    fun register(routes: List<PlainDrivingDirectionRoute>): List<DrivingDirectionRoute> {
        return drivingDirectionRouteJpaRepository.saveAll(
            routes.map { route -> toEntity(route) }
        ).map {
            DrivingDirectionRouteImpl(it)
        }
    }

    private fun toEntity(direction: PlainDrivingDirection): DrivingDirectionEntity {
        return DrivingDirectionEntity(
            startAddress = direction.startAddress,
            endAddress = direction.endAddress,
            startLatitude = direction.startPosition.latitude,
            startLongitude = direction.startPosition.longitude,
            endLatitude = direction.endPosition.latitude,
            endLongitude = direction.endPosition.longitude,
            startAt = direction.startAt,
            endAt = direction.endAt,
            distance = direction.distance,
            duration = direction.duration,
            carId = direction.carId,
        )
    }

    private fun toEntity(route: PlainDrivingDirectionRoute): DrivingDirectionRouteEntity {
        return DrivingDirectionRouteEntity(
            routeKey = RouteKey(route.directionId, route.order),
            subRoutes = route.subRoutes.map { Pair(it.latitude, it.longitude) },
        )
    }
}
