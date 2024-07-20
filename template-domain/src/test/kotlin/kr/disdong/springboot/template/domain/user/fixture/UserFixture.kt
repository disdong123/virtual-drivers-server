package kr.disdong.springboot.template.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.springboot.template.domain.common.fixture.FixtureUtil
import kr.disdong.springboot.template.domain.user.model.User
import kr.disdong.springboot.template.domain.user.model.impl.UserJpaImpl

object UserFixture {

    fun any(): User = FixtureUtil.monkey().giveMeBuilder<UserJpaImpl>()
        .sample()
}
