package kr.disdong.virtual.drivers.infrastructure.jpa.domain.car.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.disdong.virtual.drivers.infrastructure.jpa.common.model.BaseEntity

@Entity(name = "car")
class CarEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(
        nullable = false,
        unique = false,
        length = 45,
    )
    val name: String,

    @Column(
        nullable = false,
        unique = true,
        length = 20,
    )
    val number: String,

    @Column(
        nullable = false,
        unique = false,
        length = 100,
    )
    val ownerId: Long,
) : BaseEntity()
