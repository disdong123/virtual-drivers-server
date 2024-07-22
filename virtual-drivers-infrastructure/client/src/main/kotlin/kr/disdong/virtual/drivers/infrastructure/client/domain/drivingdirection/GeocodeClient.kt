package kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection

import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.GeocodeException
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.GeocodeResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class GeocodeClient(
    private val naverMapClient: RestClient,
) {

    fun getPositionByAddress(address: String): GeocodeResponse {
        return naverMapClient.get().uri("/map-geocode/v2/geocode") {
            it.queryParam("query", address)
            it.build()
        }
            .retrieve()
            .body(GeocodeResponse::class.java) ?: throw GeocodeException()
    }
}
