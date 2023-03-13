package com.seb.exchangerates.controller;

import com.seb.exchangerates.model.GetExchangeRatesByDateResponse;
import com.seb.exchangerates.model.ObjectFactory;
import com.seb.exchangerates.service.ExchangeRateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** ExchangeRateController */
@RestController
@RequestMapping("/")
public class ExchangeRateController {

  @Autowired private ExchangeRateClient exchangeRateClient;

  @GetMapping
  public String getExchangeRates(@RequestParam String date) {
    ObjectFactory factory = new ObjectFactory();

    GetExchangeRatesByDateResponse response = exchangeRateClient.getExchangeRatesByDate(date);

    return response.getGetExchangeRatesByDateResult().toString();
  }
}
