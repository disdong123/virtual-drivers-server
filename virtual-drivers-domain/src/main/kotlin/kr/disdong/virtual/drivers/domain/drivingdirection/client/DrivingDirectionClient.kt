package kr.disdong.virtual.drivers.domain.drivingdirection.client

import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.DrivingDirectionRestClient
import org.springframework.stereotype.Component

@Component
class DrivingDirectionClient(
    private val drivingDirectionRestClient: DrivingDirectionRestClient,
) {

    fun getDrivingDirection() {
    }
}
