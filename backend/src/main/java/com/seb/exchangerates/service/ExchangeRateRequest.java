package com.seb.exchangerates.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"date"})
@XmlRootElement(name = "getExchangeRatesByDate")
public class ExchangeRateRequest {

  @XmlElement(name = "Dt", required = true)
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar date;

  public ExchangeRateRequest() {}

  public ExchangeRateRequest(XMLGregorianCalendar date) {
    this.date = date;
  }

  public XMLGregorianCalendar getDate() {
    return date;
  }

  public void setDate(XMLGregorianCalendar date) {
    this.date = date;
  }
}
