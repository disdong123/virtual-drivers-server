package kr.disdong.virtual.drivers.domain.drivingdirection.model

interface PlainDrivingDirectionRoute : DrivingDirectionRouteData

interface DrivingDirectionRoute : DrivingDirectionRouteData {
    fun finish()
}

interface DrivingDirectionRouteData {
    val id: Long
    val routeKey: RouteKey
    val subRoutes: List<Position>
}

data class RouteKey(val directionId: Long, val order: Int)
