package com.example.testtask;

import com.example.testtask.dao.entity.Person;
import com.example.testtask.dao.repository.PersonsCrudRepository;
import com.example.testtask.service.DateService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@RestController
public class TestTaskApplication {

  PersonsCrudRepository personsCrudRepository;

  public TestTaskApplication(PersonsCrudRepository crudRepository) {
    personsCrudRepository = crudRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TestTaskApplication.class, args);
  }

  @GetMapping("/get-person")
  public String hello(@RequestParam(value = "id", defaultValue = "0") Integer id) {
    Optional<Person> optionalPerson = personsCrudRepository.findById(id);
    if (optionalPerson.isPresent()) {
      Person person = optionalPerson.get();
      JSONObject jo = new JSONObject();
      jo.put("name", person.getName());
      jo.put("surname", person.getSurname());
      try {
        int age = DateService.getAge(person.getBirthday());
        jo.put("age", age);
      } catch (IllegalArgumentException e) {
        jo.put("age", e.getMessage());
      }

      return jo.toString();
    } else {
      return "Cannot find person with this id";
    }
  }

}
