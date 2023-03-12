package com.seb.exchangerates.model;

import java.util.ArrayList;
import java.util.List;

/** ExchangeRates */
public class ExchangeRates {

  private List<ExchangeRate> exchangeRates = new ArrayList<>();

  public List<ExchangeRate> getExchangeRates() {
    return exchangeRates;
  }

  public void setExchangeRates(List<ExchangeRate> exchangeRates) {
    this.exchangeRates = exchangeRates;
  }
}
