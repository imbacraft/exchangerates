package com.seb.exchangerates.service;

import com.seb.exchangerates.model.ExchangeRates;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"exchangeRates"})
@XmlRootElement(name = "getExchangeRatesByDateResponse")
public class ExchangeRateResponse {

  @XmlElement(required = true)
  protected ExchangeRates exchangeRates;

  public ExchangeRates getExchangeRates() {
    return exchangeRates;
  }

  public void setExchangeRates(ExchangeRates exchangeRates) {
    this.exchangeRates = exchangeRates;
  }
}
