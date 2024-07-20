package kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model

import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Lob
import jakarta.persistence.Table
import kr.disdong.virtual.drivers.infrastructure.jpa.common.model.BaseEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.converter.DrivingDirectionRouteConverter
import java.math.BigDecimal

@Entity(name = "driving_direction_route")
@Table(name = "driving_direction_route", indexes = [Index(name = "idx_direction_id_route_order", columnList = "directionId, routeOrder", unique = true)])
class DrivingDirectionRouteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Embedded
    val routeKey: RouteKey,

    @Convert(converter = DrivingDirectionRouteConverter::class)
    @Column
    @Lob
    val subRoutes: List<Pair<BigDecimal, BigDecimal>>
) : BaseEntity()

@Embeddable
class RouteKey(
    @Column
    val directionId: Long,

    @Column
    val routeOrder: Int,
)
