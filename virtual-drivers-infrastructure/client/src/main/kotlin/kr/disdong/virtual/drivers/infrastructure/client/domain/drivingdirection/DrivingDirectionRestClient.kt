package kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection

import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.DrivingDirectionResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class DrivingDirectionRestClient(
    private val naverMapClient: RestClient,
) {

    fun getDrivingDirection(start: String, end: String, option: String): DrivingDirectionResponse? {
        return naverMapClient
            .get()
            .uri("/driving")
            .retrieve()
            .body(DrivingDirectionResponse::class.java)
    }
}
