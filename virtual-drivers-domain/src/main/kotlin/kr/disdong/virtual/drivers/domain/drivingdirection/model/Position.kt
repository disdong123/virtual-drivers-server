package kr.disdong.virtual.drivers.domain.drivingdirection.model

import java.math.BigDecimal

data class Position(
    val latitude: BigDecimal,
    val longitude: BigDecimal,
) {
    override fun toString(): String {
        return "$longitude,$latitude"
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
