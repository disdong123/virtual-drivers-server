package kr.disdong.virtual.drivers.domain.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.drivingdirection.dto.FindDrivingDirectionResponse
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.DrivingDirectionClient
import kr.disdong.virtual.drivers.infrastructure.client.domain.drivingdirection.DrivingDirectionOption
import org.springframework.stereotype.Component

@Component
class DrivingDirectionFinder(
    private val drivingDirectionClient: DrivingDirectionClient,
) {

    fun find(startPosition: Position, endPosition: Position): FindDrivingDirectionResponse {
        return FindDrivingDirectionResponse.of(
            drivingDirectionClient.getDrivingDirection(
                startPosition.toString(),
                endPosition.toString(),
                DrivingDirectionOption.TRAFAST
            )
        )
    }
}
