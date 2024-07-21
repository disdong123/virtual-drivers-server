package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.common.fixture.FixtureUtil
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.model.DrivingDirectionEntity

object DrivingDirectionEntityFixture {
    fun any(): DrivingDirectionEntity = FixtureUtil.monkey().giveMeBuilder<DrivingDirectionEntity>()
        .sample()
}
