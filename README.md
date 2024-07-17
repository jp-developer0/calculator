# CalculatorAPI
A Spring Boot Rest API to calculate the square root of an input number array

To start app:
loanpro/CalculatorAPI$ mvn spring-boot:run


To create DB:
sudo -u postgres psql template1
psql (16.3 (Ubuntu 16.3-1.pgdg22.04+1), servidor 14.12 (Ubuntu 14.12-0ubuntu0.22.04.1))
template1=# \i CalculatorAPI/calculator_api_db.sql 
psql:CalculatorAPI/calculator_api_db.sql:1: ERROR:  database "calculatordb" does not exist
psql:CalculatorAPI/calculator_api_db.sql:2: ERROR:  role "calculator" does not exist
CREATE ROLE
CREATE DATABASE
psql (16.3 (Ubuntu 16.3-1.pgdg22.04+1), servidor 14.12 (Ubuntu 14.12-0ubuntu0.22.04.1))
Ahora está conectado a la base de datos «calculatordb» con el usuario «postgres».
ALTER DEFAULT PRIVILEGES
ALTER DEFAULT PRIVILEGES
CREATE TABLE
CREATE SEQUENCE
calculatordb=# 
