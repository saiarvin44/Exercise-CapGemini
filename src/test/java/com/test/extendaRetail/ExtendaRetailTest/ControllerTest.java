package com.test.extendaRetail.ExtendaRetailTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ControllerTest {
  @Autowired PerfectNumberService service;
  @Autowired private MockMvc mvc;
  private ObjectMapper mapper = new ObjectMapper();

  @Test
  public void isPerfect() throws Exception {

    mvc.perform(get("/perfect/6")).andExpect(status().isOk());
  }

  @Test
  public void perfectNumbers() throws Exception {

    mvc.perform(get("/perfect/numbers/1/10")).andExpect(status().isOk());
  }
}
