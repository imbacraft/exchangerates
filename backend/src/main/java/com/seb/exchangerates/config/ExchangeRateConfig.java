package com.seb.exchangerates.config;

import com.seb.exchangerates.service.ExchangeRateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ExchangeRateConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("http://www.lb.lt/WebServices/ExchangeRates/ExchangeRates.asmx?WSDL");
    return marshaller;
  }

  @Bean
  public ExchangeRateService setupExchangeRateClient(Jaxb2Marshaller marshaller) {
    ExchangeRateService client = new ExchangeRateService();
    client.setDefaultUri("http://localhost:8080/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
