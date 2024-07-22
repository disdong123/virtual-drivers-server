package kr.disdong.virtual.drivers.domain.drivingdirection.model

import java.time.ZonedDateTime

interface PlainDrivingDirection : DrivingDirectionData

interface DrivingDirection : DrivingDirectionData {
    fun finish()
}

interface DrivingDirectionData {
    val id: Long
    val startAddress: String
    val startPosition: Position
    val startAt: ZonedDateTime
    val endAddress: String
    val endPosition: Position
    val endAt: ZonedDateTime
    val distance: Int
    val duration: Int
    val carId: Long
    // val routes: List<PlainDrivingDirectionRoute>
}
