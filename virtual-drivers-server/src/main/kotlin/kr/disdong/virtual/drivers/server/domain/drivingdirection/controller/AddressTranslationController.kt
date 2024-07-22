package kr.disdong.virtual.drivers.server.domain.drivingdirection.controller

import kr.disdong.virtual.drivers.common.dto.TemplateResponse
import kr.disdong.virtual.drivers.domain.drivingdirection.helper.AddressTranslator
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/translation/v1")
class AddressTranslationController(
    private val addressTranslator: AddressTranslator,
) {

    @GetMapping("/address")
    fun getPositionByAddress(
        @ModelAttribute request: GetPositionByAddressRequest
    ): TemplateResponse<Position> {
        return TemplateResponse.of(addressTranslator.translate(request.address))
    }
}

data class GetPositionByAddressRequest(
    val address: String,
    val translationType: AddressTranslationType,
)

enum class AddressTranslationType {
    POSITION,
    JIBUN,
}
