package com.example.testtask;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = TestTaskApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class E2ETest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getUserTest() throws Exception {
    mvc.perform(get("/get-person?id=1")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("name1"))
        .andExpect(jsonPath("$.surname").value("surname1"))
        .andExpect(jsonPath("$.age").value("22"));

    mvc.perform(get("/get-person?id=4")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("name4"))
        .andExpect(jsonPath("$.surname").value("surname4"))
        .andExpect(jsonPath("$.age").value("35"));

    mvc.perform(get("/get-person?id=5"))
        .andExpect(content().string("Cannot find person with this id"));
  }
}
