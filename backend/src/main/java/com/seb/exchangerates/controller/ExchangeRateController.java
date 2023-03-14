package com.seb.exchangerates.controller;

import com.seb.exchangerates.dto.ExchangeRates;
import com.seb.exchangerates.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** ExchangeRateController */
@RestController
@RequestMapping("/")
public class ExchangeRateController {

  @Autowired private ExchangeRateService exchangeRateService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ExchangeRates getExchangeRates(@RequestParam String date) {

    ExchangeRates rates = exchangeRateService.deserializeExchangeRatesByDateResponse(date);

    ExchangeRates previousDayRates = exchangeRateService.getPreviousDayExchangeRates(rates);

    return rates;
  }
}
