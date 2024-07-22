package kr.disdong.virtual.drivers.domain.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.DrivingDirectionImpl
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.DrivingDirectionRouteImpl
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.PlainDrivingDirectionRouteImpl
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

    companion object {
        private const val SUB_ROUTE_MAX_SIZE = 5
    }

    @Transactional
    fun register(direction: PlainDrivingDirection, routes: List<Position>): Pair<DrivingDirectionImpl, List<DrivingDirectionRoute>> {
        val drivingDirection = DrivingDirectionImpl(drivingDirectionJpaRepository.save(toEntity(direction)))
        val drivingDirectionRoutes = register(toPlainDrivingDirectionRoutes(drivingDirection.id, routes))
        return Pair(drivingDirection, drivingDirectionRoutes)
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

    private fun toPlainDrivingDirectionRoutes(directionId: Long, routes: List<Position>): List<PlainDrivingDirectionRoute> = routes.chunked(SUB_ROUTE_MAX_SIZE).mapIndexed { index, subRoute ->
        PlainDrivingDirectionRouteImpl(
            subRoutes = subRoute,
            directionId = directionId,
            order = index,
        )
    }
}
