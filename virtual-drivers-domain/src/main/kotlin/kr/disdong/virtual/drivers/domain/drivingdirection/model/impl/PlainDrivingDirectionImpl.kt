package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import java.time.ZonedDateTime

class PlainDrivingDirectionImpl(
    override val id: Long = 0,
    override val startAddress: String,
    override val endAddress: String,
    override val startPosition: Position,
    override val endPosition: Position,
    override val startAt: ZonedDateTime,
    override val endAt: ZonedDateTime,
    override val distance: Int,
    override val duration: Int,
    override val carId: Long,
) : PlainDrivingDirection
