package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.common.fixture.FixtureUtil

object DrivingDirectionImplFixture {
    fun any(): DrivingDirectionImpl = FixtureUtil.monkey().giveMeBuilder<DrivingDirectionImpl>()
        .sample()
}
