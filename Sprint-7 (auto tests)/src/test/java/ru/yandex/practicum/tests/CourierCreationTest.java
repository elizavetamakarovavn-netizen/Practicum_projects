package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.model.Courier;
import org.example.ru.yandex.practicum.steps.CourierSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.apache.http.HttpStatus.*;


public class CourierCreationTest extends BaseTest {

    private CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Before
    public void setUp() {
        courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(15))
                .setPassword(RandomStringUtils.randomAlphabetic(15))
                .setFirstName(RandomStringUtils.randomAlphabetic(15));

    }

    @Test
    @Description("Курьера можно создать, успешный запрос возвращает ok: true и правильный код ответа")
    public void shouldCreateCourierTest() {
        courierSteps
                .createCourier(courier)
                .statusCode(SC_CREATED)
                .body("ok", is(true));
    }

    @Test
    @Description("Невозможно создать двух одинаковых курьеров")
    public void shouldNotAllowDuplicateCourierCreationTest() {
        courierSteps.createCourier(courier).statusCode(201);
        courierSteps.createCourier(courier)
                .statusCode(SC_CONFLICT)
                .body("message", equalTo("Этот логин уже используется"));
    }

    @Test
    @Description("Создание курьера без логина возвращает ошибку")
    public void shouldReturnErrorWhenLoginMissingTest() {
        Courier courierWithoutLogin = new Courier()
                .setLogin(null)
                .setPassword(RandomStringUtils.randomAlphabetic(15))
                .setFirstName(RandomStringUtils.randomAlphabetic(15));
        courierSteps.createCourier(courierWithoutLogin)
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @Description("Создание курьера без пароля возвращает ошибку")
    public void shouldReturnErrorWhenPasswordMissingTest() {
        Courier courierWithoutPassword = new Courier()
                .setLogin(RandomStringUtils.randomAlphabetic(15))
                .setPassword(null)
                .setFirstName(RandomStringUtils.randomAlphabetic(15));
        courierSteps.createCourier(courierWithoutPassword)
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @Description("Невозможно создать курьера с существующим логином")
    public void shouldReturnErrorWhenLoginAlreadyExistsTest() {
        courierSteps.createCourier(courier)
                .statusCode(SC_CREATED)
                .body("ok", is(true));
        courierSteps.createCourier(courier)
                .statusCode(SC_CONFLICT)
                .body("message", equalTo("Этот логин уже используется"));
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

