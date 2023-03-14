package com.seb.exchangerates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.seb.exchangerates.serializer.BigDecimalDeserializer;
import com.seb.exchangerates.serializer.BigDecimalSerializer;
import com.seb.exchangerates.serializer.LocalDateDeserializer;
import com.seb.exchangerates.serializer.LocalDateSerializer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "ExchangeRates")
public class ExchangeRates {

  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Item> items;

  @Data
  public static class Item {

    @JacksonXmlProperty(localName = "date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @JacksonXmlProperty(localName = "currency")
    private String currency;

    @JacksonXmlProperty(localName = "quantity")
    private String quantity;

    @JacksonXmlProperty(localName = "rate")
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal rate;

    @JacksonXmlProperty(localName = "unit")
    private String unit;
  }
}
