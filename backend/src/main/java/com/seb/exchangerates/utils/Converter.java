package com.seb.exchangerates.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Converter {

  public static XMLGregorianCalendar convertStringDateToXMLGregorianCalendar(String dateString) {

    LocalDate localDate = LocalDate.parse(dateString);
    ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
    GregorianCalendar gregorianCalendar = GregorianCalendar.from(zonedDateTime);

    XMLGregorianCalendar xmlGregorianCalendarDate = null;

    try {
      xmlGregorianCalendarDate =
          DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    } catch (DatatypeConfigurationException e) {
      e.printStackTrace();
    }

    return xmlGregorianCalendarDate;
  }
}
