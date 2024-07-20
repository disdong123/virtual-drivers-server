package kr.disdong.virtual.drivers.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.common.fixture.FixtureUtil
import kr.disdong.virtual.drivers.domain.user.model.User
import kr.disdong.virtual.drivers.domain.user.model.impl.UserJpaImpl

object UserFixture {

    fun any(): User = FixtureUtil.monkey().giveMeBuilder<UserJpaImpl>()
        .sample()
}
