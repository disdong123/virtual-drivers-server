package kr.disdong.virtual.drivers.server.domain.drivingdirection.view

import kr.disdong.virtual.drivers.domain.drivingdirection.helper.MapManager
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MapView(
    private val mapManager: MapManager,
) {

    @GetMapping("/main")
    fun map(
        model: Model
    ): String {
        model.addAttribute("clientId", mapManager.getClientId())
        return "map/NaverMap"
    }
}
