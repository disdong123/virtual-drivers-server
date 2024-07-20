package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position

class PlainDrivingDirectionRouteImpl(
    override val id: Long = 0,
    override val directionId: Long,
    override val order: Int,
    override val subRoutes: List<Position>,
) : PlainDrivingDirectionRoute
