package kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection

import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.DrivingDirectionApiResponse
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.InvalidDrivingDirectionResponseException
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class DrivingDirectionClient(
    private val naverMapClient: RestClient,
) {

    fun getDrivingDirection(start: String, end: String, option: DrivingDirectionOption): DrivingDirectionApiResponse {
        return naverMapClient
            .get()
            .uri("/map-direction/v1/driving") {
                it.queryParam("start", start)
                it.queryParam("goal", end)
                it.queryParam("option", option.value)
                it.build()
            }
            .retrieve()
            .body(DrivingDirectionApiResponse::class.java) ?: throw InvalidDrivingDirectionResponseException("")
    }
}

enum class DrivingDirectionOption(val value: String, val desc: String) {
    TRAFAST("trafast", "빠른길"),
    TRACOMFORT("tracomfort", "편한길"),
    TRAOPTIMAL("traoptimal", "최적"),
}
