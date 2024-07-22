package kr.disdong.virtual.drivers.domain.drivingdirection.helper

import kr.disdong.virtual.drivers.infrastructure.client.core.config.properties.NaverMapProperties
import org.springframework.stereotype.Component

@Component
class MapManager(
    private val naverMapProperties: NaverMapProperties,
) {

    fun getClientId(): String {
        return naverMapProperties.clientId
    }
}
