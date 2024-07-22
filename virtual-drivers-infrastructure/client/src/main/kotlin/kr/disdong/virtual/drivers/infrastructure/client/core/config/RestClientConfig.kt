package kr.disdong.virtual.drivers.infrastructure.client.core.config

import kr.disdong.virtual.drivers.infrastructure.client.core.config.properties.NaverMapProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig(
    private val naverMapProperties: NaverMapProperties,
) {

    @Bean
    fun naverMapClient(): RestClient {
        return RestClient.builder()
            .baseUrl(naverMapProperties.baseUrl)
            .defaultHeaders {
                it["X-NCP-APIGW-API-KEY-ID"] = naverMapProperties.clientId
                it["X-NCP-APIGW-API-KEY"] = naverMapProperties.clientSecret
            }
            .build()
    }
}
