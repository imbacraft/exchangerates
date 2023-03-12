# Exchange Rates App

## Introduction

## Requirements

1. Rest-based web application
2. Can display a list of changes for currency rates for the selected date.
3. The user should be able to select a date and get a list of changes for currency rate of each currency.
4. The list of changes has to be ordered by biggest Exchange rate increase first.
5. The change for currency rate is calculated by comparing currency rate on selected date and one day before.
6. The currency exchange rates can be taken from a public web service:
   [link](http://www.lb.lt/webservices/ExchangeRates/ExchangeRates.asmx?op=getExchangeRatesByDate)

## Tools used

## Architecture

This folder structure allows for a clear separation of concerns between the frontend and backend components of the application, making it easier to manage and maintain the codebase. Additionally, this structure is in line with best practices for building Java Spring Boot and Angular web applications.

In this case, the application could have the following architecture:

Frontend: Angular

Angular will be used to create a single-page application (SPA) to provide a user interface for the application.
Backend: Java Spring Boot

Java Spring Boot will be used to build a RESTful API to provide data to the frontend.
Spring Boot can be used to consume the SOAP web service and transform the response into a format that can be consumed by the Angular frontend.
Spring Boot can also calculate the changes in currency rates based on the user's selection.
Data Source: SOAP Web Service

The SOAP web service will be used as the source of exchange rate data for the application.
Deployment: Docker and Kubernetes

Docker can be used to containerize the frontend and backend applications.
Kubernetes can be used to deploy and manage the containers in a scalable and resilient way.
This architecture allows for separation of concerns, with the frontend and backend being developed and deployed independently. It also enables easy scaling and maintenance of the application.

I decided to consume the SOAP web service from Spring Boot backend and expose a RESTful API for the Angular frontend to consume.

Here are some reasons why:

- Security: Consuming SOAP web services directly from the frontend can expose sensitive information such as credentials or tokens. By consuming the SOAP web service from the backend, you can protect sensitive information from being exposed to the public.

Performance: Consuming SOAP web services directly from the frontend can add an additional layer of complexity to the application. Consuming the SOAP web service from the backend and then exposing a RESTful API can improve performance by reducing the number of requests made by the frontend.

Scalability: Exposing a RESTful API allows for easier scaling of the application. If you need to add more frontend servers, you can do so without worrying about the SOAP web service being overloaded.

Therefore, it is recommended to consume the SOAP web service from the Spring Boot backend and expose a RESTful API for the Angular frontend to consume.

## How to run the application using the jar file

## How to run the application from source code

To run your Spring Boot application using the Maven Wrapper, you need to open a terminal/command prompt in the root directory of your project where the mvnw file is located. Then, run the following command:

On Unix-based systems:

```shell
./mvnw spring-boot:run
```

On Windows:

```shell
mvnw spring-boot:run
```

This will download the required dependencies, compile your code, and start the Spring Boot application.
