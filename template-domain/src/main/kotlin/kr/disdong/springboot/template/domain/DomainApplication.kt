package kr.disdong.springboot.template.domain

import kr.disdong.springboot.template.jpa.JpaApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(JpaApplication::class)
class DomainApplication
