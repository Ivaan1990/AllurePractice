package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class MainPage extends BasePage {

    @FindBy(xpath = "//ul[@id='desktopMenuMain']//a[text()]")
    List<WebElement> mainMenuItems;

    @FindBy(xpath = "//a[@title='Перейти в корзину']")
    public WebElement buttonCart;

    public void selectMainMenu(String menuItem){
        for(WebElement item : mainMenuItems){
            if(item.getText().equalsIgnoreCase(menuItem)){
                new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        Assert.fail("Не найден пункт меню с наименованием" + menuItem);
    }

}