package ru.yandex.practicum.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.model.Order;
import org.example.ru.yandex.practicum.steps.OrderSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.Description;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.Matchers.notNullValue;
import static org.apache.http.HttpStatus.*;

@RunWith(Parameterized.class)

public class OrderCreationTest extends BaseTest{
    private OrderSteps orderSteps = new OrderSteps();
    private Order order;
    private String[] colors;

    @Before
    public void setUp() {
        order = new Order();
        order.setFirstName(RandomStringUtils.randomAlphabetic(15))
                .setLastName(RandomStringUtils.randomAlphabetic(15))
                .setAddress(RandomStringUtils.randomAlphabetic(15))
                .setMetroStation(RandomStringUtils.randomNumeric(1))
                .setPhone("+7" + RandomStringUtils.randomNumeric(10))
                .setRentTime(Integer.parseInt(RandomStringUtils.randomNumeric(1)))
                .setDeliveryDate(LocalDate.now().plusDays(2).toString())
                .setComment(RandomStringUtils.randomAlphabetic(20));
    }

    public OrderCreationTest(String[] colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Цвета: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}},
                {null},
        });
    }

    @Test
    @Description("Создание заказа с разными вариантами цвета, тело ответа содержит track")
    public void shouldCreateOrderWithDifferentColorsTest() {
        order.setColor(colors);
        orderSteps.createOrder(order)
                .statusCode(SC_CREATED)
                .body("track", notNullValue());
    }
}

