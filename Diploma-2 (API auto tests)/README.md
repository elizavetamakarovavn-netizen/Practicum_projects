# Stellar Burgers API Tests

🌎  [English](#english) |  🇷🇺  [Русский](#russian)

## Russian
## Описание проекта

Проект содержит автоматизированные API-тесты для сервиса **Stellar Burgers**.
Тесты проверяют основные эндпоинты системы: регистрацию пользователя, авторизацию и создание заказа. Тестирование выполнено с использованием **REST Assured** и **JUnit 4**, с генерацией отчётов в **Allure**.

## Проверяемый функционал

**Создание пользователя**

* создание уникального пользователя
* ошибка при регистрации уже существующего пользователя
* ошибка при отсутствии обязательных полей

**Логин пользователя**

* авторизация существующего пользователя
* ошибка при неверном логине или пароле

**Создание заказа**

* создание заказа с авторизацией
* создание заказа без авторизации
* создание заказа с ингредиентами
* ошибка при создании заказа без ингредиентов
* ошибка при передаче неверного хеша ингредиентов

## Технологии

* Java 11
* Maven
* JUnit 4
* REST Assured
* Allure Report

## Особенности

* тестирование REST API сервиса
* проверка кодов ответа и тела ответа
* формирование **Allure-отчёта** по результатам тестирования

## English

## Project Description

This project contains **automated API tests for the Stellar Burgers service**.
The tests verify the main system endpoints: **user registration, user login, and order creation**. Testing is implemented using **REST Assured** and **JUnit 4**, with **Allure reports** generated for test results.

## Tested Functionality

### User Creation

* creating a unique user
* error when registering an already existing user
* error when required fields are missing

### User Login

* successful login with an existing user
* error when an incorrect login or password is provided

### Order Creation

* creating an order with authorization
* creating an order without authorization
* creating an order with ingredients
* error when creating an order without ingredients
* error when an invalid ingredient hash is provided

## Technologies

* Java 11
* Maven
* JUnit 4
* REST Assured
* Allure Report

## Features

* REST API testing
* validation of response status codes and response body
* generation of **Allure test reports**

