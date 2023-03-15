package com.seb.exchangerates.client;

import com.seb.exchangerates.constants.URL;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlString;
import com.seb.exchangerates.model.GetExchangeRatesByDateXmlStringResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ExchangeRateByDateClient extends WebServiceGatewaySupport {

  private static final Logger logger = LoggerFactory.getLogger(ExchangeRateByDateClient.class);

  public GetExchangeRatesByDateXmlStringResponse getExchangeRatesByDateResponse(String date) {

    GetExchangeRatesByDateXmlString request = new GetExchangeRatesByDateXmlString();

    request.setDate(date.replace(".", "-"));

    logger.info("Attempting to receive exchange rates by date response for date: {}", date);

    GetExchangeRatesByDateXmlStringResponse response =
        (GetExchangeRatesByDateXmlStringResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    URL.EXCHANGE_RATES,
                    request,
                    new SoapActionCallback(URL.EXCHANGE_RATES_BY_DATE_STRING_SOAP_ACTION));

    if (response == null) {
      logger.error("Failed to receive exchange rates by date response for date: {}", date);
    } else {
      logger.info("Successfully received exchange rates by date response for date: {}", date);
    }

    return response;
  }
}
