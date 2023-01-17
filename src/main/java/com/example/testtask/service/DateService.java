package com.example.testtask.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class DateService {

  public static int getAge(String birthday){
    try {
      LocalDate birth = LocalDate.parse(birthday);
      LocalDate today = LocalDate.now();
      return Period.between(birth, today).getYears();
    }
    catch (DateTimeParseException e){
      throw new IllegalArgumentException("Cannot parse passed date");
    }
  }
}
