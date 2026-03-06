package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.model.Courier;
import org.example.ru.yandex.practicum.steps.CourierSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.apache.http.HttpStatus.*;

public class CourierLoginTest extends BaseTest {

    private final CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Before
    public void setUp() {
        courier = new Courier()
                .setLogin(RandomStringUtils.randomAlphabetic(15))
                .setPassword(RandomStringUtils.randomAlphabetic(15));
        courierSteps.createCourier(courier)
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
    }

    @Test
    @Description("Курьер может авторизоваться, успешный запрос возвращает правильный код ответа и id")
    public void shouldLoginCourierTest() {
        courierSteps.loginCourier(courier)
                .statusCode(SC_OK)
                .body("id", notNullValue());
    }

    @Test
    @Description("Ошибка при авторизации с неправильным логином")
    public void shouldReturnErrorWithWrongLoginTest() {
        Courier wrongLogin = new Courier()
                .setLogin("wrong" + RandomStringUtils.randomAlphabetic(15))
                .setPassword(courier.getPassword());
        courierSteps.loginCourier(wrongLogin)
                .statusCode(SC_NOT_FOUND)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @Description("Ошибка при авторизации с неправильным паролем")
    public void shouldReturnErrorWithWrongPasswordTest() {
        Courier wrongPassword = new Courier()
                .setLogin(courier.getLogin())
                .setPassword("wrong" + RandomStringUtils.randomAlphabetic(15));
        courierSteps.loginCourier(wrongPassword)
                .statusCode(SC_NOT_FOUND)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @Description("Ошибка при авторизации, если не передан логин")
    public void shouldReturnErrorWhenLoginMissingTest() {
        Courier withoutLogin = new Courier()
                .setPassword(courier.getPassword());
        courierSteps.loginCourier(withoutLogin)
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @Description("Ошибка при авторизации, если не передан пароль")
    public void shouldReturnErrorWhenPasswordMissingTest() {
        Courier withoutPassword = new Courier()
                .setLogin(courier.getLogin());
        courierSteps.loginCourier(withoutPassword)
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для входа"));
    }


    @Test
    @Description("Ошибка при авторизации несуществующего курьера")
    public void shouldReturnErrorWhenCourierDoesNotExistTest() {
        Courier nonExistentCourier = new Courier()
                .setLogin("nonexistent" + RandomStringUtils.randomAlphabetic(15))
                .setPassword(RandomStringUtils.randomAlphabetic(15));

        courierSteps.loginCourier(nonExistentCourier)
                .statusCode(SC_NOT_FOUND)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @After
    public void tearDown() {
        Integer id = courierSteps.loginCourier(courier)
                .extract()
                .path("id");

        if (id != null) {
            courier.setId(id);
            courierSteps.deleteCourier(courier);
        }
    }
}



