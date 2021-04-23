package com.test.extendaRetail.ExtendaRetailTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/numbers/{from}/{to}")
  public ResponseEntity<PerfectNumber> findPerfects(
      @PathVariable Integer from, @PathVariable Integer to) {
    logger.debug("Finding perfect numbers within the range");
    PerfectNumberDTO perfectNumberDTO = new PerfectNumberDTO();
    perfectNumberDTO.setFrom(from < to ? from : to);
    perfectNumberDTO.setTo(from < to ? to : from);
    PerfectNumber response = service.findPerfects(perfectNumberDTO);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
