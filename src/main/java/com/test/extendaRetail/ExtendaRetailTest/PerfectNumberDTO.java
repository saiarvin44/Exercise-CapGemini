package com.test.extendaRetail.ExtendaRetailTest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerfectNumberDTO {
  @JsonProperty("From")
  private Integer from;

  @JsonProperty("To")
  private Integer to;
}
