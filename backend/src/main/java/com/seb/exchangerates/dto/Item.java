package com.seb.exchangerates.dto;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
  @XmlElement(name = "currency")
  private String currency;

  @XmlElement(name = "code")
  private String code;

  @XmlElement(name = "date")
  private LocalDate date;

  @XmlElement(name = "quantity")
  private String quantity;

  @XmlElement(name = "rate")
  private String rate;

  public Item() {}
}
