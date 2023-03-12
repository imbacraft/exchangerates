package com.seb.exchangerates.service;

import com.seb.exchangerates.dto.*;
import com.seb.exchangerates.model.ExchangeRates;
import com.seb.exchangerates.utils.Converter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class ExchangeRateService extends WebServiceGatewaySupport {

  @Value("${soap.endpoint}")
  private String soapEndpoint;

  public void getExchangeRates(String date) {

    soapEndpoint = "http://www.lb.lt/WebServices/ExchangeRates/ExchangeRates.asmx";

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

    ExchangeRates exchangeRates = response.getExchangeRates();

    System.out.println(exchangeRates);
  }
}
