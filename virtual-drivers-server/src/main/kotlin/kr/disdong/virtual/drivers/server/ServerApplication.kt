package kr.disdong.virtual.drivers.server

import kr.disdong.virtual.drivers.domain.DomainApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DomainApplication::class)
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
