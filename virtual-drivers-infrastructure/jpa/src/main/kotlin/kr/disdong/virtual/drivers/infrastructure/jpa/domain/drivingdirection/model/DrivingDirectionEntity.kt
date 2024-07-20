package kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table
import kr.disdong.virtual.drivers.infrastructure.jpa.common.model.BaseEntity
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity(name = "driving_direction")
@Table(name = "driving_direction", indexes = [Index(name = "idx_car_id", columnList = "carId")])
class DrivingDirectionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(
        nullable = false,
        unique = false,
    )
    val startAddress: String,

    @Column(
        nullable = false,
        unique = false,
    )
    val endAddress: String,

    @Column(
        nullable = false,
        unique = false,
    )
    val startLatitude: BigDecimal,

    @Column(
        nullable = false,
        unique = false,
    )
    val startLongitude: BigDecimal,

    @Column(
        nullable = false,
        unique = false,
    )
    val endLatitude: BigDecimal,

    @Column(
        nullable = false,
        unique = false,
    )
    val endLongitude: BigDecimal,

    @Column(
        nullable = false,
        unique = false,
    )
    val startAt: ZonedDateTime,

    @Column(
        nullable = false,
        unique = false,
    )
    val endAt: ZonedDateTime,

    @Column(
        nullable = false,
        unique = false,
    )
    val distance: Int,

    @Column(
        nullable = false,
        unique = false,
    )
    val duration: Int,

    @Column(
        nullable = false,
        unique = false,
    )
    val carId: Long,
) : BaseEntity()
