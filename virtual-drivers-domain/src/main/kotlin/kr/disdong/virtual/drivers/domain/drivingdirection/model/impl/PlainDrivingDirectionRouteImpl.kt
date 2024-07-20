package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import kr.disdong.virtual.drivers.domain.drivingdirection.model.RouteKey

class PlainDrivingDirectionRouteImpl(
    override val id: Long = 0,
    override val routeKey: RouteKey,
    override val subRoutes: List<Position>,
) : PlainDrivingDirectionRoute
