package kr.disdong.virtual.drivers.domain.drivingdirection.helper

import kr.disdong.virtual.drivers.common.logger.logger
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.GeocodeClient
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.GeocodeAddress
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.GeocodeException
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto.GeocodeResponse
import org.springframework.stereotype.Component

@Component
class AddressTranslator(
    private val geocodeClient: GeocodeClient,
) {
    private val logger = logger<AddressTranslator>()

    fun translate(address: String): Position {
        val response = geocodeClient.getPositionByAddress(address)
        if (response.isSuccess().not()) {
            logger.error("$response")
            throw GeocodeException()
        }

        return response.toPosition()
    }

    private fun GeocodeResponse.toPosition(): Position {
        if (addresses.isNullOrEmpty()) {
            throw GeocodeException()
        }

        return addresses!!.first().toPosition()
    }

    private fun GeocodeAddress.toPosition(): Position {
        return Position(y.toBigDecimal(), x.toBigDecimal())
    }
}
