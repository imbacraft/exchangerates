package com.seb.exchangerates.client;

import com.seb.exchangerates.constants.URL;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlString;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlStringResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ExchangeRateByDateClient extends WebServiceGatewaySupport {

  public GetExchangeRatesByDateXmlStringResponse getExchangeRatesByDate(String date) {

    GetExchangeRatesByDateXmlString request = new GetExchangeRatesByDateXmlString();

    request.setDate(date.replace(".", "-"));

    GetExchangeRatesByDateXmlStringResponse response =
        (GetExchangeRatesByDateXmlStringResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    URL.EXCHANGE_RATES,
                    request,
                    new SoapActionCallback(URL.EXCHANGE_RATES_BY_DATE_STRING_SOAP_ACTION));

    return response;
  }
}
