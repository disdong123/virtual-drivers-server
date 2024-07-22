package kr.disdong.virtual.drivers.server.domain.drivingdirection

import kr.disdong.virtual.drivers.domain.car.helper.CarFinder
import kr.disdong.virtual.drivers.domain.drivingdirection.helper.DrivingDirectionFinder
import kr.disdong.virtual.drivers.domain.drivingdirection.helper.DrivingDirectionRegister
import kr.disdong.virtual.drivers.server.domain.drivingdirection.dto.DrivingDirectionRequest
import kr.disdong.virtual.drivers.server.domain.drivingdirection.dto.DrivingDirectionResponse
import kr.disdong.virtual.drivers.server.domain.drivingdirection.exception.CarUnavailableException
import org.springframework.stereotype.Service

@Service
class DrivingDirectionService(
    private val carFinder: CarFinder,
    private val drivingDirectionRegister: DrivingDirectionRegister,
    private val drivingDirectionFinder: DrivingDirectionFinder,
) {

    fun create(request: DrivingDirectionRequest): DrivingDirectionResponse {
        val car = carFinder.findNoDrivingCar() ?: throw CarUnavailableException()
        val response = drivingDirectionFinder.find(request.toStartPosition(), request.toEndPosition())
        val pair = drivingDirectionRegister.register(response.toPlainDrivingDirection(request.startAddress, request.endAddress, car.id), response.routes)
        return DrivingDirectionResponse.of(
            pair.first,
            pair.second,
        )
    }
}
