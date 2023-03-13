package com.seb.exchangerates.service;

import com.seb.exchangerates.model.GetExchangeRatesByDate;
import com.seb.exchangerates.model.GetExchangeRatesByDateResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ExchangeRateClient extends WebServiceGatewaySupport {

  public GetExchangeRatesByDateResponse getExchangeRatesByDate(String date) {

    GetExchangeRatesByDate request = new GetExchangeRatesByDate();

    request.setDate(date.replace(".", "-"));
    GetExchangeRatesByDateResponse response =
        (GetExchangeRatesByDateResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    "http://www.lb.lt/webservices/exchangerates/exchangerates.asmx", request);
    return response;
  }
}
