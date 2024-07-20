package kr.disdong.springboot.template.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.springboot.template.domain.common.fixture.FixtureUtil
import kr.disdong.springboot.template.domain.user.model.PlainUser
import kr.disdong.springboot.template.domain.user.model.impl.PlainUserJpaImpl

object PlainUserFixture {

    fun any(): PlainUser = FixtureUtil.monkey().giveMeBuilder<PlainUserJpaImpl>()
        .sample()
}
