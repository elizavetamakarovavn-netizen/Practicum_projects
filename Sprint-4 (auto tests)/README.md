# Yandex Samokat UI Tests

🌎  [English](#english) |  🇷🇺  [Русский](#russian)

## Russian

## Описание проекта
Проект содержит UI-автотесты для учебного веб-сервиса Яндекс Самокат.
Тесты написаны на основе готовых ручных тест-сценариев и автоматизированы с использованием Selenium WebDriver и JUnit 4.

## Проверяемый функционал
- Работа выпадающего списка в разделе «Вопросы о важном»
- Позитивный сценарий оформления заказа самоката
- Проверка двух точек входа в заказ: кнопки «Заказать» вверху и внизу страницы
- Проверка появления всплывающего окна об успешном создании заказа

Тесты выполняются **с разными наборами данных с использованием параметризации**.

## Технологии
- Java 11
- Maven
- JUnit 4
- Selenium WebDriver
- Google Chrome
- Mozilla Firefox

## Особенности реализации
- Использован паттерн Page Object Model
- Тесты разделены по функциональности
- Каждый тест закрывает браузер после выполнения (driver.quit())

## Запуск тестов

Запуск тестов в **Firefox:** 

```bash
mvn -Dtest=<test_name> -Dbrowser=firefox test
```
Запуск тестов в **Chrome:** 

```bash
mvn -Dtest=<test_name> -Dbrowser=chrome test
```

## English

## Project Description

This project contains **UI automated tests for the educational web service Yandex Samokat**.
The tests are based on prepared manual test scenarios and automated using **Selenium WebDriver** and **JUnit 4**.

## Tested Functionality

* functionality of the **FAQ dropdown section**
* positive scenario of **scooter order creation**
* verification of two order entry points: **"Order" button at the top and bottom of the page**
* verification of the **successful order confirmation popup**

Tests are executed with **different datasets using parameterization**.

## Technologies

* Java 11
* Maven
* JUnit 4
* Selenium WebDriver
* Google Chrome
* Mozilla Firefox

## Implementation Features

* **Page Object Model (POM)** design pattern is used
* tests are grouped by functionality
* each test closes the browser after execution (`driver.quit()`)

## Running Tests

Run tests in **Firefox**:

```bash id="a1c9m4"
mvn -Dtest=<test_name> -Dbrowser=firefox test
```

Run tests in **Chrome**:

```bash id="k6w2fp"
mvn -Dtest=<test_name> -Dbrowser=chrome test
```

