package kr.disdong.virtual.drivers.server.domain.drivingdirection.exception

import kr.disdong.virtual.drivers.common.exception.BadRequestException

class CarUnavailableException : BadRequestException("Car is not available")
