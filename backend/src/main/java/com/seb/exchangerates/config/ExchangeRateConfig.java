package com.seb.exchangerates.config;

import com.seb.exchangerates.service.ExchangeRateClient;
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
    marshaller.setContextPath("com.seb.exchangerates.model");
    // marshaller.setPackagesToScan("com.seb.exchangerates.model");
    return marshaller;
  }

  @Bean
  public ExchangeRateClient setupExchangeRateClient(Jaxb2Marshaller marshaller) {
    ExchangeRateClient client = new ExchangeRateClient();

    // client.setDefaultUri("http://webservices.lb.lt/ExchangeRates/ExchangeRates.asmx");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
