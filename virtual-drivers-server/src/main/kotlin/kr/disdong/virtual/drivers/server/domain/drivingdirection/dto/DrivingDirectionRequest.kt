package kr.disdong.virtual.drivers.server.domain.drivingdirection.dto

import kr.disdong.virtual.drivers.domain.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import java.math.BigDecimal

data class DrivingDirectionRequest(
    val startAddress: String,
    val startLatitude: BigDecimal,
    val startLongitude: BigDecimal,
    val endAddress: String,
    val endLatitude: BigDecimal,
    val endLongitude: BigDecimal,
) {

    fun toStartPosition(): Position {
        return Position(
            latitude = startLatitude,
            longitude = startLongitude,
        )
    }

    fun toEndPosition(): Position {
        return Position(
            latitude = endLatitude,
            longitude = endLongitude,
        )
    }
}

data class DrivingDirectionResponse(
    val startPosition: Position,
    val endPosition: Position,
    val distance: Int,
    val duration: Int,
    val route: List<Position>,
) {

    companion object {

        fun of(response: DrivingDirection, routes: List<DrivingDirectionRoute>): DrivingDirectionResponse {
            return DrivingDirectionResponse(
                startPosition = response.startPosition,
                endPosition = response.startPosition,
                distance = response.distance,
                duration = response.duration,
                route = routes.map { it.subRoutes }.flatten(),
            )
        }
    }
}
