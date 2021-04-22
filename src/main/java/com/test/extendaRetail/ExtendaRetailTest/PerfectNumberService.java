package com.test.extendaRetail.ExtendaRetailTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PerfectNumberService {
  private static Logger logger = LoggerFactory.getLogger(PerfectNumberController.class);

  public PerfectNumber findIfPerfect(Integer number) {
    PerfectNumber response = new PerfectNumber();
    Integer perfect =
        IntStream.rangeClosed(1, number / 2).filter(digit -> number % digit == 0).sum();
    if (perfect == number) {
      response.setIsPerfect("True");
      logger.info("Perfect number");
    } else {
      response.setIsPerfect("False");
      logger.info("Not a perfect number");
    }
    return response;
  }

  public PerfectNumber findPerfects(PerfectNumberDTO perfectNumberDTO) {
    PerfectNumber response = new PerfectNumber();
    List<Integer> list = new ArrayList<>();
    IntStream.rangeClosed(perfectNumberDTO.getFrom(), perfectNumberDTO.getTo())
        .forEach(
            number -> {
              int temp =
                  IntStream.rangeClosed(1, number / 2).filter(digit -> number % digit == 0).sum();
              if (temp == number) list.add(number);
            });
    logger.debug("Found perfect numbers withing the range");
    response.setPerfectNumbers(list);
    return response;
  }
}
