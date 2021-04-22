package com.test.extendaRetail.ExtendaRetailTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceTest {

  @Autowired private PerfectNumberService service;

  @Test
  public void testIsPerfectYes() {
    PerfectNumber response = new PerfectNumber();
    response.setIsPerfect("True");
    Assertions.assertEquals(service.findIfPerfect(6), response);
  }

  @Test
  public void testIsPerfectNo() {
    PerfectNumber response = new PerfectNumber();
    response.setIsPerfect("False");
    Assertions.assertEquals(service.findIfPerfect(5), response);
  }

  @Test
  public void testFindPerfect() {
    PerfectNumberDTO request = new PerfectNumberDTO();
    request.setFrom(1);
    request.setTo(10);
    List<Integer> list = Arrays.asList(6);
    PerfectNumber response = new PerfectNumber();
    response.setPerfectNumbers(list);
    Assertions.assertEquals(service.findPerfects(request), response);
  }
}
