package kr.disdong.virtual.drivers.domain.drivingdirection.model.impl

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.common.fixture.FixtureUtil

object PlainDrivingDirectionRouteImplFixture {
    fun any(): PlainDrivingDirectionRouteImpl = FixtureUtil.monkey().giveMeBuilder<PlainDrivingDirectionRouteImpl>()
        .sample()
}
