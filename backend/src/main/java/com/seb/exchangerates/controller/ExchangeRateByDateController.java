package com.seb.exchangerates.controller;

import com.seb.exchangerates.dto.ExchangeRateDifference;
import com.seb.exchangerates.dto.ExchangeRates;
import com.seb.exchangerates.service.ExchangeRateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ExchangeRateByDateController {

  @Autowired private ExchangeRateService exchangeRateService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ExchangeRateDifference> getExchangeRateDifferences(@RequestParam String date) {

    ExchangeRates rates = exchangeRateService.deserializeExchangeRatesByDateResponse(date);

    ExchangeRates previousDayRates = exchangeRateService.getPreviousDayExchangeRates(rates);

    System.out.println(previousDayRates);

    List<ExchangeRateDifference> differenceList =
        exchangeRateService.getExchangeRateDifferences(rates, previousDayRates);

    return differenceList;
  }
}
