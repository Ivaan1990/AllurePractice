package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import ru.aplana.autotests.pages.CartPage;

public class CartSteps {
    CartPage cartPage = new CartPage();

    @Step("товар {0} рисутствует в корзине")
    public void stepCheckProduct(String productName){
        Assert.assertTrue(String.format("Продукт [%s] отсутствует в корзине", productName),
                cartPage.productExist(productName));
    }

    @Step("итоговая сумма равна - {0}")
    public void stepCheckTotalAmount(String expectedAmount){
        String actualAmount = cartPage.getTotalAmount();
        Assert.assertEquals(String.format("Итоговая сумма равна - [%s]. Ожидалось значение - [%s]", actualAmount, expectedAmount),
                actualAmount, expectedAmount);

    }
}
