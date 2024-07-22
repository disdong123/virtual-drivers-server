package kr.disdong.virtual.drivers.server

import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.domain.car.helper.CarRegister
import kr.disdong.virtual.drivers.domain.car.model.impl.PlainCarImpl
import kr.disdong.virtual.drivers.domain.drivingdirection.helper.DrivingDirectionRegister
import kr.disdong.virtual.drivers.domain.user.helper.UserRegister
import kr.disdong.virtual.drivers.domain.user.model.impl.PlainUserImpl
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DomainApplication::class)
class ServerApplication(
    private val userRegister: UserRegister,
    private val carRegister: CarRegister,
    private val drivingDirectionRegister: DrivingDirectionRegister,
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val user = userRegister.register(PlainUserImpl(name = "123", phone = "1234"))
        carRegister.register(PlainCarImpl(carName = "쏘나타", carNumber = "1231234", ownerId = user.id))
    }
}

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
