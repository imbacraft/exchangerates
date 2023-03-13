package com.seb.exchangerates.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

@JacksonXmlRootElement(localName = "ExchangeRates")
public class ExchangeRates {

  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Item> items;

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public static class Item {

    private String date;
    private String currency;
    private String quantity;
    private String rate;
    private String unit;

    public String getDate() {
      return date;
    }

    @JacksonXmlProperty(localName = "date")
    public void setDate(String date) {
      this.date = date;
    }

    public String getCurrency() {
      return currency;
    }

    @JacksonXmlProperty(localName = "currency")
    public void setCurrency(String currency) {
      this.currency = currency;
    }

    public String getQuantity() {
      return quantity;
    }

    @JacksonXmlProperty(localName = "quantity")
    public void setQuantity(String quantity) {
      this.quantity = quantity;
    }

    public String getRate() {
      return rate;
    }

    @JacksonXmlProperty(localName = "rate")
    public void setRate(String rate) {
      this.rate = rate;
    }

    public String getUnit() {
      return unit;
    }

    @JacksonXmlProperty(localName = "unit")
    public void setUnit(String unit) {
      this.unit = unit;
    }

    @Override
    public String toString() {
      return "Item [date="
          + date
          + ", currency="
          + currency
          + ", quantity="
          + quantity
          + ", rate="
          + rate
          + ", unit="
          + unit
          + "]";
    }
  }
}
