package org.example.ru.yandex.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.model.Courier;
import static io.restassured.RestAssured.given;

public class CourierSteps {

    public static final String COURIER = "/api/v1/courier";
    public static final String LOGIN = "/api/v1/courier/loginCourier";
    public static final String DELETE = "/api/v1/courier/{id}";

@Step("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return given()
                .body(courier)
                .when()
                .post(COURIER)
                .then();
    }
@Step("Логин курьера")
    public ValidatableResponse loginCourier(Courier courier) {
        return  given()
                .body(courier)
                .when()
                .post(LOGIN)
                .then();
    }
@Step("Удаление курьера")
    public ValidatableResponse deleteCourier(Courier courier){
        return  given()
                .pathParams("id", courier.getId())
                .when()
                .delete(DELETE)
                .then();
    }

}
