package com.test.extendaRetail.ExtendaRetailTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(
    classes = ExtendaRetailTestApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
  @LocalServerPort private int port;

  @Autowired private RestTemplate restTemplate;

  @Test
  public void testIsPerfect() {
    assertTrue(
        this.restTemplate
            .getForObject("http://localhost:" + port + "/perfect/6", PerfectNumber.class)
            .getIsPerfect()
            .equals("True"));
  }

  @Test
  public void testIsNotPerfect() {
    assertTrue(
        this.restTemplate
            .getForObject("http://localhost:" + port + "/perfect/7", PerfectNumber.class)
            .getIsPerfect()
            .equals("False"));
  }

  @Test
  public void testGetPerfectNumbers() {
    List<Integer> list = Arrays.asList(6);
    assertTrue(
        this.restTemplate
            .getForObject("http://localhost:" + port + "/perfect/numbers/1/10", PerfectNumber.class)
            .getPerfectNumbers()
            .equals(list));
  }
}
