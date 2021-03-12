# Form application backend
This repository contains backend for simple form application.
Made by Aleksandr Aleksandrov

## Technologies and dependencies

  * **Maven** - Project management
  * **Spring Boot** - Stand-alone, production-grade Spring based Applications
  * **PostgreSQL** - Database
  * **Lombok** - Build tool, automate your logging variables
  * **JPA** - Programming interface specification that describes the management of relational data in enterprise Java applications.
  * **JUnit** - Unit testing framework

## Installation

**Before installation make sure, that [PostgreSQL](https://www.postgresql.org/download/) is installed on your machine**

1. Clone this repository with your favorite IDE
2. Open project and paste in terminal `mvn install`
3. Open postgre terminal and create database with name alekaldb 
* _Or you can connect with your own database_:
  * Go to `/src/main/resources` and find there `application.properties`
  * Change `spring.datasource.url` with your own database name
4. Go to `/src/main/java/com.example.formbackend/` and run `FormBackendApplication` java class 
5. Now backend is running on port 8080
  * To check that out go to `localhost:8080/api/v1/person/all` and you will see a json objects of two persons


## What could be better?

* Could add Docker configuration, so both front and back will run on Docker container.
* CI/CD pipeline
