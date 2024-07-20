package kr.disdong.virtual.drivers.domain.drivingdirection.model

interface PlainDrivingDirectionRoute : DrivingDirectionRouteData

interface DrivingDirectionRoute : DrivingDirectionRouteData {
    fun finish()
}

interface DrivingDirectionRouteData {
    val id: Long
    val directionId: Long
    val order: Int
    val subRoutes: List<Position>
}
