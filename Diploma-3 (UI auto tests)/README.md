# Stellar Burgers UI Tests

🌎  [English](#english) |  🇷🇺  [Русский](#russian)

## Russian

## Описание проекта

Проект содержит UI-автотесты для веб-приложения **Stellar Burgers**.
Тесты написаны с использованием **Selenium WebDriver** и **JUnit 4**, а результаты выполнения формируются в **Allure Report**.

## Проверяемый функционал

**Регистрация**

* успешная регистрация пользователя
* ошибка при вводе некорректного пароля (менее 6 символов)

**Вход**

* вход по кнопке **«Войти в аккаунт»** на главной странице
* вход через кнопку **«Личный кабинет»**
* вход через форму **регистрации**
* вход через форму **восстановления пароля**

**Раздел «Конструктор»**

* переход к разделу **«Булки»**
* переход к разделу **«Соусы»**
* переход к разделу **«Начинки»**

## Технологии

* Java 11
* Maven
* JUnit 4
* Selenium WebDriver
* Allure Report

## Особенности

* применён паттерн **Page Object Model**
* тесты выполняются в **Google Chrome** и **Яндекс Браузере**
* формируется **Allure-отчёт**

## Запуск тестов

**Запуск всех тестов:** mvn clean test

**Запуск тестов в Яндекс.Браузере:** mvn -Dtest=<имя теста> -Dbrowser=yandex test

**Запуск тестов в Google Chrome:** mvn -Dtest=<имя теста> -Dbrowser=chrome test

**Allure-отчет:** allure serve target/allure-results

## English

## Project Description

This project contains **UI automated tests for the Stellar Burgers web application**.
The tests are implemented using **Selenium WebDriver** and **JUnit 4**, with **Allure Report** used to generate test execution reports.

## Tested Functionality

### Registration

* successful user registration
* error when entering an invalid password (less than 6 characters)

### Login

* login via the **"Sign in to account"** button on the main page
* login via the **"Personal account"** button
* login through the **registration form**
* login through the **password recovery form**

### Constructor Section

* navigation to the **"Buns"** section
* navigation to the **"Sauces"** section
* navigation to the **"Fillings"** section

## Technologies

* Java 11
* Maven
* JUnit 4
* Selenium WebDriver
* Allure Report

## Features

* **Page Object Model (POM)** design pattern is used
* tests run in **Google Chrome** and **Yandex Browser**
* **Allure reports** are generated for test results

## Running Tests

Run all tests:

```bash
mvn clean test
```

Run tests in **Yandex Browser**:

```bash
mvn -Dtest=<test_name> -Dbrowser=yandex test
```

Run tests in **Google Chrome**:

```bash
mvn -Dtest=<test_name> -Dbrowser=chrome test
```

Generate and open **Allure report**:

```bash
allure serve target/allure-results
```

