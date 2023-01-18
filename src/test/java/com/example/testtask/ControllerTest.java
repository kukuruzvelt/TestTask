package com.example.testtask;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testtask.dao.entity.Person;
import com.example.testtask.dao.repository.PersonsCrudRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TestTaskApplication.class)
public class ControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private PersonsCrudRepository personsCrudRepository;

  @Test
  public void TestTaskApplicationTest()
      throws Exception {

    int testAge = 10;
    Person testPerson = new Person();
    testPerson.setName("testName");
    testPerson.setSurname("testName");
    testPerson.setBirthday(LocalDate.now().minus(testAge, ChronoUnit.YEARS).toString());

    given(personsCrudRepository.findById(1)).willReturn(Optional.of(testPerson));

    mvc.perform(get("/get-person?id=1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value(testPerson.getName()))
        .andExpect(jsonPath("$.surname").value(testPerson.getName()))
        .andExpect(jsonPath("$.age").value(String.valueOf(testAge)));
  }

}
