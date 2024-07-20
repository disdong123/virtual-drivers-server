package kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.repository

import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.DrivingDirectionRouteEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.QDrivingDirectionRouteEntity
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.RouteKey
import org.springframework.data.jpa.repository.JpaRepository

interface DrivingDirectionRouteJpaRepository : JpaRepository<DrivingDirectionRouteEntity, Long>, DrivingDirectionRouteCustomJpaRepository

interface DrivingDirectionRouteCustomJpaRepository {
    fun findCurrentRoutes(keys: List<RouteKey>): List<DrivingDirectionRouteEntity>
}

class DrivingDirectionRouteCustomJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : DrivingDirectionRouteCustomJpaRepository {
    private val drivingDirectionRouteEntity = QDrivingDirectionRouteEntity.drivingDirectionRouteEntity
    override fun findCurrentRoutes(keys: List<RouteKey>): List<DrivingDirectionRouteEntity> {
        val builder = BooleanBuilder()
        keys.map {
            builder.or(
                drivingDirectionRouteEntity.routeKey.eq(it)
            )
        }

        return jpaQueryFactory
            .selectFrom(drivingDirectionRouteEntity)
            .where(
                builder,
                drivingDirectionRouteEntity.isDeleted.isFalse,
            )
            .fetch()
    }
}
