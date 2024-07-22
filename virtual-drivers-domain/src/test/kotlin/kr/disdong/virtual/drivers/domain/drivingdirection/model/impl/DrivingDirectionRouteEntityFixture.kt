package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.common.fixture.FixtureUtil
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.DrivingDirectionRouteEntity

object DrivingDirectionRouteEntityFixture {
    fun any(): DrivingDirectionRouteEntity = FixtureUtil.monkey().giveMeBuilder<DrivingDirectionRouteEntity>()
        .sample()
}
