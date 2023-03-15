package com.seb.exchangerates.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.seb.exchangerates.client.ExchangeRateByDateClient;
import com.seb.exchangerates.dto.ExchangeRateDifference;
import com.seb.exchangerates.dto.ExchangeRates;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlStringResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateByDateService {

  @Autowired private ExchangeRateByDateClient exchangeRateClient;
  private static final Logger logger = LoggerFactory.getLogger(ExchangeRateByDateService.class);

  private ExchangeRates deserializeExchangeRatesByDateResponse(
      String date, GetExchangeRatesByDateXmlStringResponse response) {

    XmlMapper xmlMapper = new XmlMapper();

    String xmlData = response.getGetExchangeRatesByDateXmlStringResult();

    ExchangeRates rates = null;

    logger.info(
        "Attempting to deserialize (from XML) exchange rates by date response for date: {}", date);

    try {
      rates = xmlMapper.readValue(xmlData, ExchangeRates.class);
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    logger.info(
        "Successfully deserialized (from XML) exchange rates by date response for date: {}", date);

    return rates;
  }

  private ExchangeRates getExchangeRatesByDate(String date) {

    GetExchangeRatesByDateXmlStringResponse response =
        exchangeRateClient.getExchangeRatesByDateResponse(date);

    ExchangeRates ratesByDate = deserializeExchangeRatesByDateResponse(date, response);

    return ratesByDate;
  }

  private ExchangeRates getPreviousDayExchangeRates(ExchangeRates nextDayRates) {

    LocalDate previousDay = nextDayRates.getItems().get(0).getDate().minusDays(1);
    String previousDayString = previousDay.toString();

    GetExchangeRatesByDateXmlStringResponse response =
        exchangeRateClient.getExchangeRatesByDateResponse(previousDayString);

    ExchangeRates previousDayRates =
        deserializeExchangeRatesByDateResponse(previousDayString, response);

    return previousDayRates;
  }

  private List<ExchangeRateDifference> getExchangeRateDifferences(
      ExchangeRates ratesByDate, ExchangeRates ratesByPreviousDay) {

    List<ExchangeRateDifference> differencesList = new ArrayList<>();
    BigDecimal rate;

    BigDecimal rateDifference;
    String currency;
    long quantity;

    for (int i = 0; i < ratesByDate.getItems().size(); i++) {

      rate = ratesByDate.getItems().get(i).getRate();

      rateDifference =
          ratesByDate
              .getItems()
              .get(i)
              .getRate()
              .subtract(ratesByPreviousDay.getItems().get(i).getRate());

      currency = ratesByDate.getItems().get(i).getCurrency();

      quantity = Long.parseLong(ratesByDate.getItems().get(i).getQuantity());

      ExchangeRateDifference exchangeRateDifference =
          new ExchangeRateDifference(currency, rate, rateDifference, quantity);

      differencesList.add(exchangeRateDifference);
    }

    // Sort list. Biggest rate increase first (descending order)
    differencesList =
        differencesList.stream()
            .sorted(Comparator.comparing(ExchangeRateDifference::getDifference).reversed())
            .collect(Collectors.toList());

    return differencesList;
  }

  public List<ExchangeRateDifference> serveExchangeRateDifferences(String date) {

    ExchangeRates rates = getExchangeRatesByDate(date);

    ExchangeRates previousDayRates = getPreviousDayExchangeRates(rates);

    List<ExchangeRateDifference> differenceList =
        getExchangeRateDifferences(rates, previousDayRates);

    return differenceList;
  }
}
