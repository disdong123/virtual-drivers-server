package kr.disdong.virtual.drivers.domain.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.DrivingDirectionEntityFixture
import kr.disdong.virtual.drivers.domain.drivingdirection.model.impl.PlainDrivingDirectionImplFixture
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.repository.DrivingDirectionJpaRepository
import kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.repository.DrivingDirectionRouteJpaRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.any

class DrivingDirectionRegisterTest {
    private val drivingDirectionJpaRepository: DrivingDirectionJpaRepository = mock()
    private val drivingDirectionRouteJpaRepository: DrivingDirectionRouteJpaRepository = mock()
    private val sut = DrivingDirectionRegister(drivingDirectionJpaRepository, drivingDirectionRouteJpaRepository)

    @Test
    fun `simple test`() {
        Mockito.`when`(drivingDirectionJpaRepository.save(any())).thenReturn(DrivingDirectionEntityFixture.any())

        val response = sut.register(PlainDrivingDirectionImplFixture.any())

        assertNotNull(response)
    }
}
