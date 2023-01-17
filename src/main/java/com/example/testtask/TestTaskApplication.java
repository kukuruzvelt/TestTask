package com.example.testtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestTaskApplication.class, args);
  }

  @GetMapping("/get-user")
  public String hello(@RequestParam(value = "id", defaultValue = "0") String id) {
    return String.format("ID is %s!", id);
  }

}
