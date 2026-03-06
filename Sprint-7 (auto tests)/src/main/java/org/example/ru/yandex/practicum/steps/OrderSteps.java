package org.example.ru.yandex.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.model.Order;
import static io.restassured.RestAssured.given;

public class OrderSteps {

    public static final String ORDER = "/api/v1/orders";

    @Step("Создание заказа")
    public ValidatableResponse createOrder(Order order) {
        return given()
                .body(order)
                .when()
                .post(ORDER)
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse getOrders(Integer courierId, String nearestStation, Integer limit, Integer page) {
        return given()
                .queryParam("courierId", courierId)
                .queryParam("nearestStation", nearestStation)
                .queryParam("limit", limit)
                .queryParam("page", page)
                .when()
                .get(ORDER)
                .then();
    }
}



