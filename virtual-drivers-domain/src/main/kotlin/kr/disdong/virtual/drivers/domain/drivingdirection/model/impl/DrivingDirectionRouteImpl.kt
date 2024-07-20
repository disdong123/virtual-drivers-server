package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.DrivingDirectionRouteEntity

class DrivingDirectionRouteImpl(
    private val entity: DrivingDirectionRouteEntity,
) : DrivingDirectionRoute {
    override val id: Long
        get() = entity.id
    override val directionId: Long
        get() = entity.routeKey.directionId
    override val order: Int
        get() = entity.routeKey.routeOrder
    override val subRoutes: List<Position>
        get() = entity.subRoutes.map { Position(it.first, it.second) }

    override fun finish() {
        entity.isDeleted = true
    }
}
