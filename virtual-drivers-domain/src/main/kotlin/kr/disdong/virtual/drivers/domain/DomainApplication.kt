package kr.disdong.virtual.drivers.domain

import kr.disdong.virtual.drivers.infrastructure.client.ClientApplication
import kr.disdong.virtual.drivers.infrastructure.jpa.JpaApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(JpaApplication::class, ClientApplication::class)
class DomainApplication
