package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.common.fixture.FixtureUtil

object PlainDrivingDirectionImplFixture {
    fun any(): PlainDrivingDirectionImpl = FixtureUtil.monkey().giveMeBuilder<PlainDrivingDirectionImpl>()
        .sample()
}
