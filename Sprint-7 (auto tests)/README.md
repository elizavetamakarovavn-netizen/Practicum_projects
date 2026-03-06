# Yandex Samokat API Tests

🌎  [English](#english) |  🇷🇺  [Русский](#russian)

## Russian

## Описание проекта

Проект содержит автоматизированные API-тесты для учебного сервиса Яндекс Самокат.
Тестирование выполняется с использованием **RestAssured** и **JUnit 4**, результаты тестов формируются в **Allure Report**.
Перед автоматизацией ручки сервиса были протестированы вручную в **Postman**.

## Проверяемый функционал

### Создание курьера
- Успешное создание курьера
- Ошибка при создании дубликата
- Проверка обязательных полей
### Логин курьера
- Успешная авторизация
- Ошибки при неверных данных или отсутствии полей
- Получение id после успешного логина
### Создание заказа
- Заказ с цветом BLACK или GREY
- Заказ с двумя цветами
- Заказ без указания цвета
- Проверка наличия track в ответе
- Использование параметризации
### Получение списка заказов
- Проверка, что ответ содержит список заказов

## Технологии

- Java 11
- Maven
- JUnit 4
- RestAssured
- Allure Report
  
## Особенности

- API тестируется через **REST-запросы**
- Используется **параметризация тестов**
- Сформирован отчёт **Allure**

## English

## Project Description

This project contains **automated API tests for the educational service Yandex Samokat**.
Testing is implemented using **RestAssured** and **JUnit 4**, with test results generated in **Allure Report**.
Before automation, the service endpoints were **manually tested in Postman**.

## Tested Functionality

### Courier Creation

* successful courier creation
* error when creating a duplicate courier
* validation of required fields

### Courier Login

* successful authorization
* errors when incorrect data is provided or required fields are missing
* receiving **id** after successful login

### Order Creation

* order with color **BLACK** or **GREY**
* order with **both colors**
* order **without specifying a color**
* verification that the response contains **track**
* use of **test parameterization**

### Order List

* verification that the response contains a **list of orders**

## Technologies

* Java 11
* Maven
* JUnit 4
* RestAssured
* Allure Report

## Features

* API testing via **REST requests**
* use of **test parameterization**
* **Allure report** generation

