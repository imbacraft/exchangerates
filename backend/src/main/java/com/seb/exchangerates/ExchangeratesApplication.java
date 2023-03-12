package com.seb.exchangerates;

import com.seb.exchangerates.service.ExchangeRateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeratesApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExchangeratesApplication.class, args);
    String date = "2013-10-10";
    ExchangeRateService service = new ExchangeRateService();

    service.getExchangeRates(date);
  }
}
