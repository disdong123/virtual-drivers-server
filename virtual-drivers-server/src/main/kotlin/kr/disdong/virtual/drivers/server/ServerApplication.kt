package kr.disdong.virtual.drivers.server

import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.domain.car.helper.CarRegister
import kr.disdong.virtual.drivers.domain.car.model.impl.PlainCarImpl
import kr.disdong.virtual.drivers.domain.drivingdirection.helper.DrivingDirectionRegister
import kr.disdong.virtual.drivers.domain.drivingdirection.model.Position
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.PlainDrivingDirectionImpl
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.PlainDrivingDirectionRouteImpl
import kr.disdong.virtual.drivers.domain.user.helper.UserRegister
import kr.disdong.virtual.drivers.domain.user.model.impl.PlainUserImpl
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import java.math.BigDecimal
import java.time.ZonedDateTime

@SpringBootApplication
@Import(DomainApplication::class)
class ServerApplication(
    private val userRegister: UserRegister,
    private val carRegister: CarRegister,
    private val drivingDirectionRegister: DrivingDirectionRegister,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val user = userRegister.register(PlainUserImpl(name = "disdong", phone = "01011111111"))
        val car = carRegister.register(PlainCarImpl(carName = "쏘나타", carNumber = "123가1234", ownerId = user.id))
        val direction = drivingDirectionRegister.register(
            PlainDrivingDirectionImpl(
                startAddress = "",
                endAddress = "",
                startPosition = Position(BigDecimal.ONE, BigDecimal.ONE),
                endPosition = Position(BigDecimal.ONE, BigDecimal.ONE),
                startAt = ZonedDateTime.now(),
                endAt = ZonedDateTime.now(),
                distance = 1,
                duration = 1,
                carId = car.id,
            )
        )

        drivingDirectionRegister.register(
            listOf(
                PlainDrivingDirectionRouteImpl(
                    directionId = direction.id,
                    order = 1,
                    subRoutes = listOf(Position(BigDecimal.ONE, BigDecimal.ONE))
                )
            )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
