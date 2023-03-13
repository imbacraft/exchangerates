package com.seb.exchangerates.service;

import com.seb.exchangerates.model.GetExchangeRatesByDateXmlString;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlStringResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ExchangeRateClient extends WebServiceGatewaySupport {

  public GetExchangeRatesByDateXmlStringResponse getExchangeRatesByDate(String date) {

    GetExchangeRatesByDateXmlString request = new GetExchangeRatesByDateXmlString();

    request.setDate(date.replace(".", "-"));

    GetExchangeRatesByDateXmlStringResponse response =
        (GetExchangeRatesByDateXmlStringResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    "http://webservices.lb.lt/ExchangeRates/ExchangeRates.asmx",
                    request,
                    new SoapActionCallback(
                        "http://webservices.lb.lt/ExchangeRates/getExchangeRatesByDate_XmlString"));
    return response;
  }
}
