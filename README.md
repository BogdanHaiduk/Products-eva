## Objective of the project:

Creating a service with the Product entity and a regular expression search filter

## Project technologies:

- Java 8
- Spring Boot 2.7.5
- JUnit 5.8.2
- Mockito 4.5.1
- Postgres SQL
- Liquibase 4.8.0
- Lombok

## Steps to start a project

- You need to install JDK 1.8
- You need install Postgres SQL (default port)
- You need create databases "shop" and "shopForTest"
- You need changing username and password for DB in application.properties and test/resources/application.properties
- Database migrations will create tables and populate with some data
- Use project on port 9999

## Ports used by MS Exchanges:

- Working port - 9999
- Port for integration testing - 8888

## Endpoints:

- _**Request to get products by filter**_ **(GET)** **`/shop/product`**
    - **Query Params:**
        - `nameFilter (required) - String`
    - **Example:** 
    - `/shop/product?nameFilter=^H.*$` - returns products that do NOT start with H