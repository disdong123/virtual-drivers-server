package kr.disdong.virtual.drivers.server.domain.drivingdirection.controller

import kr.disdong.virtual.drivers.common.dto.TemplateResponse
import kr.disdong.virtual.drivers.server.domain.drivingdirection.DrivingDirectionService
import kr.disdong.virtual.drivers.server.domain.drivingdirection.dto.DrivingDirectionRequest
import kr.disdong.virtual.drivers.server.domain.drivingdirection.dto.DrivingDirectionResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/driving-direction/v1")
class DrivingDirectionController(
    private val drivingDirectionService: DrivingDirectionService,
) {

    @PostMapping
    fun create(
        @RequestBody request: DrivingDirectionRequest,
    ): TemplateResponse<DrivingDirectionResponse> {
        return TemplateResponse.of(drivingDirectionService.create(request))
    }
}
