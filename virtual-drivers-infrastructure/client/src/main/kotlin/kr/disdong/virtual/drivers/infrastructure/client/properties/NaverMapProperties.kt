package kr.disdong.virtual.drivers.infrastructure.client.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "naver.map")
data class NaverMapProperties @ConstructorBinding constructor(
    val baseUrl: String,
    val clientId: String,
    val clientSecret: String
)
