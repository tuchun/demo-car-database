package com.whnfc.packt.cardatabase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author tuchun
 * @version 2019-12-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthentication() throws Exception {
        RequestBuilder requestBuilder1 = MockMvcRequestBuilders
                .post("/login")
                .content("{\"username\":\"user\",\"password\":\"user\"}");
        this.mockMvc.perform(requestBuilder1).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        RequestBuilder requestBuilder2 = MockMvcRequestBuilders
                .post("/login")
                .content("{\"username\":\"user\",\"password\":\"userwrong\"}");
        this.mockMvc.perform(requestBuilder2).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
