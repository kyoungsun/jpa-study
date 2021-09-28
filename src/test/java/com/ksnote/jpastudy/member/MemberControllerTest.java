package com.ksnote.jpastudy.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void 회원가입_성공() throws Exception {
        // given
        String name = "kks";
        String email = "kks@kks.com";
        String city = "seoul";
        String street = "street1";
        String zipcode = "zipcode";
        MemberCreateRequest request = MemberCreateRequest.builder()
                .name(name)
                .email(email)
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .build();
        // when
        // then
        mockMvc.perform(post("/member")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}