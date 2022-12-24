# RBAC
RBAC is Role-Based Access Control system

## Requirements

* Mysql 8.0+
* Java 18
* Preferred IDE IntellijIDEA

## Run Log 

The Log file contains, the following and more

* Queries being run
* Errors/Logs

## Used Tools

* Spring Boot for developing web services
* Spring Security for authentication and authorization
* Liquibase for change management to manage the revisions of database chanages and migration files
* Junit test for unit testing
* Mockito which is a mocking framework for unit tests written in java and to add dummy functionality to mock interface
* Docker to create database
* Swagger tool to document and test APIs
* Maven which is software project management tool

## Swagger Url
http://localhost:8080/swagger-ui/index.html

## Docker Commands
* To build the database scheme run docker compose up

## Liquibase Maven Commands

* To delete all tables from database `mvn liquibase:dropAll`

* To rollback specific number of change sets `mvn liquibase:rollback -Dliquibase.rollbackCount=1`


