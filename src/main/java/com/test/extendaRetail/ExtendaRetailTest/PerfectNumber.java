package com.test.extendaRetail.ExtendaRetailTest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerfectNumber {
  @JsonProperty("IsPerfect")
  private String isPerfect;

  @JsonProperty("PerfectNumbers")
  private List<Integer> perfectNumbers;
}
