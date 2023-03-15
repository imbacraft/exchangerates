package com.seb.exchangerates.controller;

import com.seb.exchangerates.dto.ExchangeRateDifference;
import com.seb.exchangerates.service.ExchangeRateByDateService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchangerates")
@CrossOrigin(origins = "http://localhost:4200/")
public class ExchangeRateByDateController {

  @Autowired private ExchangeRateByDateService service;
  private static final Logger logger = LoggerFactory.getLogger(ExchangeRateByDateController.class);

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ExchangeRateDifference> getExchangeRateDifferences(@RequestParam String date) {

    logger.info(
        "ExchangeRateByDateController starting service to get exchange rate difference list for"
            + " date: {}",
        date);

    List<ExchangeRateDifference> differenceList = service.serveExchangeRateDifferences(date);

    if (differenceList == null) {
      logger.error(
          "ExchangeRateByDateController reports null exchange rate difference list from service for"
              + " date: {}",
          date);
    } else {
      logger.info(
          "ExchangeRateByDateController successfully got served exchange date difference list for"
              + " date: {}",
          date);
    }

    return differenceList;
  }
}
