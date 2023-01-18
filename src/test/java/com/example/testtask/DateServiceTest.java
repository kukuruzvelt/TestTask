package com.example.testtask;

import com.example.testtask.service.DateService;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DateServiceTest {

  @ParameterizedTest
  @MethodSource("dates")
  public void getAgeTest(String birthday, int expectedAge){
    Assertions.assertEquals(DateService.getAge(birthday), expectedAge);
  }

  private static Stream<Arguments> dates() {
    return Stream.of(
        Arguments.of(LocalDate.now().minus(5, ChronoUnit.YEARS).toString(), 5),
        Arguments.of(LocalDate.now().minus(9, ChronoUnit.YEARS).toString(), 9),
        Arguments.of(LocalDate.now().minus(5, ChronoUnit.YEARS)
            .plus(1, ChronoUnit.DAYS).toString(), 4)
    );
  }

}
