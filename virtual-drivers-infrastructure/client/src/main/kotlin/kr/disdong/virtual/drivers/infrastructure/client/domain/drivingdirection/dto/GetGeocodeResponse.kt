package kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.dto

import kr.disdong.virtual.drivers.common.exception.BadRequestException

data class GeocodeResponse(
    val status: GeocodeStatus,
    val addresses: List<GeocodeAddress>?,
) {
    fun isSuccess(): Boolean {
        return status == GeocodeStatus.OK
    }
}

data class GeocodeAddress(
    val x: String, // 경도
    val y: String, // 위도
)

enum class GeocodeStatus(
    val value: Int,
) {
    OK(200),
    INVALID_REQUEST(400),
    SYSTEM_ERROR(500)
}

class GeocodeException : BadRequestException("좌표를 가져오는데 실패했습니다.")
