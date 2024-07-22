package kr.disdong.virtual.drivers.domain.drivingdirection.dto

import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.PlainDrivingDirectionImpl
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.DrivingDirectionApiResponse
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.InvalidDrivingDirectionResponseException
import java.time.ZonedDateTime

data class FindDrivingDirectionResponse(
    val startPosition: Position,
    val endPosition: Position,
    val distance: Distance,
    val duration: Duration,
    val departureTime: ZonedDateTime,
    val routes: List<Position>,
) {
    companion object {
        fun of(response: DrivingDirectionApiResponse): FindDrivingDirectionResponse {
            if (response.route == null) {
                throw InvalidDrivingDirectionResponseException(response.message)
            }

            val routeData = response.route!!.trafast.first()
            return FindDrivingDirectionResponse(
                startPosition = Position(
                    latitude = routeData.summary.start.location.last(),
                    longitude = routeData.summary.start.location.first(),
                ),
                endPosition = Position(
                    latitude = routeData.summary.goal.location.last(),
                    longitude = routeData.summary.goal.location.first(),
                ),
                distance = Distance(
                    value = routeData.summary.distance,
                ),
                duration = Duration(
                    value = routeData.summary.duration,
                ),
                departureTime = routeData.summary.departureTime,
                routes = routeData.path.map {
                    Position(
                        latitude = it.last(),
                        longitude = it.first(),
                    )
                },
            )
        }
    }

    fun toPlainDrivingDirection(startAddress: String, endAddress: String, carId: Long): PlainDrivingDirection {
        return PlainDrivingDirectionImpl(
            startAddress = startAddress,
            endAddress = endAddress,
            startPosition = startPosition,
            endPosition = endPosition,
            startAt = departureTime,
            endAt = departureTime.plusSeconds(duration.value.toLong()),
            distance = distance.value,
            duration = duration.value,
            carId = carId,
        )
    }
}

data class Duration(
    val value: Int,
)

data class Distance(
    val value: Int,
)

data class Price(
    val value: Int,
)
