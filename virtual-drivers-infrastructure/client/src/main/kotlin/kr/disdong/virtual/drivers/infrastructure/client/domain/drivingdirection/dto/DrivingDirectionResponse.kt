package kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto

import com.fasterxml.jackson.annotation.JsonFormat
import kr.disdong.virtual.drivers.common.exception.NotFoundException
import java.time.ZonedDateTime

data class DrivingDirectionResponse(
    val code: Int,
    val message: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    val currentDateTime: ZonedDateTime?,
    val route: Route?,
) {
    data class Route(
        val trafast: List<RouteData>,
    ) {
        data class RouteData(
            val summary: Summary,
            val path: List<List<Double>>,
        )

        data class Summary(
            val start: LocationSummary,
            val goal: LocationSummary,
            val distance: Int,
            val duration: Int,
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
            val departureTime: ZonedDateTime,
            val bbox: List<List<Double>>,
            val tollFare: Int,
            val taxiFare: Int,
            val fuelPrice: Int,
        ) {

            data class LocationSummary(
                val location: List<Double>,
            )
        }
    }
}

class InvalidDrivingDirectionResponseException(
    message: String,
) : NotFoundException(message)
