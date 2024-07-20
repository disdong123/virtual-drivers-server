package kr.disdong.springboot.template.server.domain.user.service

import kr.disdong.springboot.template.domain.user.fixture.UserFixture
import kr.disdong.springboot.template.domain.user.service.UserManager
import kr.disdong.springboot.template.server.domain.user.dto.CreateUserBody
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

internal class UserServiceTest {

    private val userManager: UserManager = mock()
    private val sut = UserService(userManager)

    @BeforeEach
    fun setup() {
        whenever(userManager.getUser(any())).thenReturn(UserFixture.any())
        whenever(userManager.create(any())).thenReturn(UserFixture.any())
    }

    @Test
    fun `샘플 테스트 1`() {
        val response = sut.getByUserId(1)
        assertNotNull(response)
    }

    @Test
    fun `샘플 테스트 2`() {
        // given, when
        val response = sut.create(CreateUserBody("name", "010"))

        // then
        assertNotNull(response)
    }
}
