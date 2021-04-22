package com.test.extendaRetail.ExtendaRetailTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfect")
public class PerfectNumberController {

  private static Logger logger = LoggerFactory.getLogger(PerfectNumberController.class);
  @Autowired private PerfectNumberService service;

  @GetMapping("/{number}")
  public ResponseEntity<PerfectNumber> findIfPerfect(@PathVariable Integer number) {
    logger.debug("Finding if perfect number");
    PerfectNumber response = service.findIfPerfect(number);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(
      value = "/numbers",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PerfectNumber> findPerfects(
      @RequestBody PerfectNumberDTO perfectNumberDTO) {
    logger.debug("Finding perfect numbers within the range");
    PerfectNumber response = service.findPerfects(perfectNumberDTO);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
