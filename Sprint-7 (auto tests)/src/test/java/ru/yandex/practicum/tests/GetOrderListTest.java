package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import org.example.ru.yandex.practicum.steps.OrderSteps;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.apache.http.HttpStatus.*;

public class GetOrderListTest extends BaseTest{

    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    @Description("В тело ответа возвращается список заказов")
    public void shouldReturnListOfOrdersTest() {
        orderSteps.getOrders(null, null, null, null)
                .statusCode(SC_OK)
                .body("orders", notNullValue());
    }
}

