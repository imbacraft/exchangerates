package com.seb.exchangerates.service;

import com.seb.exchangerates.dto.*;
import com.seb.exchangerates.model.ExchangeRate;
import com.seb.exchangerates.utils.Converter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class ExchangeRateService extends WebServiceGatewaySupport {

  @Value("${soap.endpoint}")
  private String soapEndpoint;

  public List<ExchangeRate> getExchangeRates(LocalDate date) {

    List<ExchangeRate> exchangeRateDtos = new ArrayList<>();

    ExchangeRateRequest request = new ExchangeRateRequest();
    XMLGregorianCalendar xmlDate =
        Converter.convertStringDateToXMLGregorianCalendar(date.toString());

    request.setDate(xmlDate);

    ExchangeRateResponse response =
        (ExchangeRateResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    soapEndpoint,
                    request,
                    new SoapActionCallback(
                        "http://www.lb.lt/WebServices/ExchangeRates/getExchangeRatesByDate"));

    List<TExchangeRate> exchangeRates = response.getExchangeRates().getExchangeRate();

    for (TExchangeRate exchangeRate : exchangeRates) {
      ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
      exchangeRateDto.setCurrency(exchangeRate.getCurrency());
      exchangeRateDto.setRate(BigDecimal.valueOf(exchangeRate.getRate()));
      exchangeRateDtos.add(exchangeRateDto);
    }
    return exchangeRateDtos;
  }
}
