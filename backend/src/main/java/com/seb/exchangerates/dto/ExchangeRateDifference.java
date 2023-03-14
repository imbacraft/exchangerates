package com.seb.exchangerates.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

/** ExchangeRateDifference */
@Data
@AllArgsConstructor
public class ExchangeRateDifference {

  private String currency;
  private BigDecimal rate;
  private BigDecimal difference;
  private long quantity;
}
