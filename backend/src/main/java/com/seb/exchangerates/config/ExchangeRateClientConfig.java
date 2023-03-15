package com.seb.exchangerates.config;

import com.seb.exchangerates.client.ExchangeRateByDateClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ExchangeRateClientConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("com.seb.exchangerates.model");
    return marshaller;
  }

  @Bean
  public ExchangeRateByDateClient setupExchangeRateClient(Jaxb2Marshaller marshaller) {
    ExchangeRateByDateClient client = new ExchangeRateByDateClient();

    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
