package kr.disdong.springboot.template.domain.common.fixture

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.FixtureMonkey.builder
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin

object FixtureUtil {
    fun monkey(): FixtureMonkey = builder()
        .plugin(KotlinPlugin())
        .build()
}
