package no.repairable.backend.entity

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
class UserTest @Autowired constructor(
        val mockMvc: MockMvc
) {

    @Test
    fun `checking status ok for users endpoint`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andDo(MockMvcRestDocumentation.document("users"))

    }

}