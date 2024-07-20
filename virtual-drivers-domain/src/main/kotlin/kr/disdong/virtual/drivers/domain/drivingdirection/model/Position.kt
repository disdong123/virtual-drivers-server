package kr.disdong.virtual.drivers.domain.drivingdirection.model

data class Position(
    val latitude: Double,
    val longitude: Double,
)

data class Duration(
    val value: Int,
)

data class Distance(
    val value: Int,
)

data class Price(
    val value: Int,
)
