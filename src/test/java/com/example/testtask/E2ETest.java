package com.example.testtask;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = TestTaskApplication.class)
@AutoConfigureMockMvc
public class E2ETest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getUserTest() throws Exception {
    mvc.perform(get("/get-user?id=1")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect((ResultMatcher) jsonPath("$[0].name", is("name1")));
  }

}
