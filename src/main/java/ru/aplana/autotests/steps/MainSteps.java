package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();
    @Step("выбран пункт меню (0)")
    public void stepSelectMenuItem(String item){
        mainPage.selectMainMenu(item);
    }
    @Step ("выполняем переход в корзину")
    public void stepGoToCart(){
        mainPage.buttonCart.click();
    }
}
