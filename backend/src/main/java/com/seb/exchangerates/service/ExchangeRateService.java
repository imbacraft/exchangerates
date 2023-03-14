package com.seb.exchangerates.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.seb.exchangerates.client.ExchangeRateByDateClient;
import com.seb.exchangerates.dto.ExchangeRates;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlStringResponse;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

  @Autowired private ExchangeRateByDateClient exchangeRateClient;

  public ExchangeRates deserializeExchangeRatesByDateResponse(String date) {

    GetExchangeRatesByDateXmlStringResponse response =
        exchangeRateClient.getExchangeRatesByDate(date);

    XmlMapper xmlMapper = new XmlMapper();
    String xmlData = response.getGetExchangeRatesByDateXmlStringResult();

    ExchangeRates rates = null;

    try {
      rates = xmlMapper.readValue(xmlData, ExchangeRates.class);
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(rates.getItems());

    return rates;
  }

  public ExchangeRates getPreviousDayExchangeRates(ExchangeRates rates) {

    LocalDate previousDay = rates.getItems().get(0).getDate().minusDays(1);
    String previousDayString = previousDay.toString();

    GetExchangeRatesByDateXmlStringResponse response =
        exchangeRateClient.getExchangeRatesByDate(previousDayString);

    XmlMapper xmlMapper = new XmlMapper();
    String xmlData = response.getGetExchangeRatesByDateXmlStringResult();

    ExchangeRates previousDayRates = null;

    try {
      rates = xmlMapper.readValue(xmlData, ExchangeRates.class);
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(rates.getItems());

    return previousDayRates;
  }
}
