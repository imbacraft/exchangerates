package com.seb.exchangerates.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@XmlRootElement(name = "ExchangeRates")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRates {

  @XmlElement(name = "item")
  private List<Item> item;

  public ExchangeRates() {}
}
