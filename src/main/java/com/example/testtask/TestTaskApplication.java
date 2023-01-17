package com.example.testtask;

import com.example.testtask.dao.entity.Person;
import com.example.testtask.dao.repository.PersonsCrudRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@RestController
public class TestTaskApplication {

  PersonsCrudRepository personsCrudRepository;

  public TestTaskApplication(PersonsCrudRepository crudRepository){
    personsCrudRepository = crudRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TestTaskApplication.class, args);
  }

  @GetMapping("/get-user")
  @Transactional
  public String hello(@RequestParam(value = "id", defaultValue = "0") String id) {
    Optional<Person> person = personsCrudRepository.findById(Integer.parseInt(id));
    return String.valueOf(person);
  }

}
