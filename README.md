# Exchange Rates App

## Introduction

This is a Spring Boot application, which can display a table of the exchange rates of Litas (LTL) compared to other currencies for a specified date between 29/06/1993 and 31/12/2014.

## Requirements

1. Rest-based web application
2. Can display a list of changes for currency rates for the selected date.
3. The user should be able to select a date and get a list of changes for currency rate of each currency.
4. The list of changes has to be ordered by biggest Exchange rate increase first.
5. The change for currency rate is calculated by comparing currency rate on selected date and one day before.
6. The currency exchange rates can be taken from a public web service:
   [link](http://www.lb.lt/webservices/ExchangeRates/ExchangeRates.asmx?op=getExchangeRatesByDate)

## Tools used

1. Java 11+
2. Spring Boot v.2.6.3
3. Node.js v.19.6.0
4. Angular v.15.2.2
5. Git v.2.39.1

## Architecture

### Backend: Java Spring Boot

Java Spring Boot will be used to:

1. Build a RESTful API to provide data to the frontend.
2. Consume the SOAP web service to get the exchange rates and transform the response into a format that can be consumed by the frontend.
3. Perform the processing to calculate the exchange rate differences and sort them by descending order.

### Frontend: Angular

Angular will be used to create a single-page application (SPA) to provide a user interface for the application.

### Folder structure

```
Exchangerates
├── backend
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── seb
│       │   │           └── exchangerates
│       │   │               ├── client
│       │   │               ├── config
│       │   │               ├── constants
│       │   │               ├── controller
│       │   │               ├── dto
│       │   │               ├── model
│       │   │               ├── serializer
│       │   │               ├── service
│       │   │               └── utils
│       │   └── resources
│       │       ├── static
│       │       ├── templates
│       │       └── wsdl
│       └── test
│           └── java
│               └── com
│                   └── seb
│                       └── exchangerates
└── frontend
    └── src
        ├── app
        │   └── currencyrates
        └── assets
```

The folder structure allows for a clear separation of concerns between the frontend and backend components of the application, making it easier to manage and maintain the codebase.

## How to run the application using the jar file

1. Download or clone the repository to your local machine using the following command:
`git clone https://github.com/imbacraft/exchangerates`
2. Open the terminal or command prompt and navigate to the "backend" folder of the project.
3. Run the following command to build the application:
`mvn clean install`
4. Once the build is successful, navigate to the "target" folder inside the "backend" folder. You should see a file named "exchange-rates-app-1.0.0.jar".
5. Run the following command to start the application:
`java -jar exchange-rates-app-0.0.1-SNAPSHOT.jar`

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
