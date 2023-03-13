package com.seb.exchangerates.service;

import com.seb.exchangerates.model.GetExchangeRatesByDate;
import com.seb.exchangerates.model.GetExchangeRatesByDateResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ExchangeRateClient extends WebServiceGatewaySupport {

  public GetExchangeRatesByDateResponse getExchangeRatesByDate(String date) {

    GetExchangeRatesByDate request = new GetExchangeRatesByDate();

    request.setDate(date.replace(".", "-"));

    GetExchangeRatesByDateResponse response =
        (GetExchangeRatesByDateResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    "http://webservices.lb.lt/ExchangeRates/ExchangeRates.asmx",
                    request,
                    new SoapActionCallback(
                        "http://webservices.lb.lt/ExchangeRates/getExchangeRatesByDate"));
    return response;
  }
}
