package kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.repository

import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.DrivingDirectionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DrivingDirectionJpaRepository : JpaRepository<DrivingDirectionEntity, Long>
