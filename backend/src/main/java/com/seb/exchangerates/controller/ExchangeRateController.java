package com.seb.exchangerates.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.seb.exchangerates.dto.ExchangeRates;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlStringResponse;
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
  public GetExchangeRatesByDateXmlStringResponse getExchangeRates(@RequestParam String date) {

    GetExchangeRatesByDateXmlStringResponse response =
        exchangeRateClient.getExchangeRatesByDate(date);

    XmlMapper xmlMapper = new XmlMapper();
    String xmlData = response.getGetExchangeRatesByDateXmlStringResult();

    System.out.println(xmlData);

    ExchangeRates rates = null;

    try {
      rates = xmlMapper.readValue(xmlData, ExchangeRates.class);
    } catch (JsonMappingException e) {
      System.out.println("I'm in'");
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(rates.getItems());

    return response;
  }
}
