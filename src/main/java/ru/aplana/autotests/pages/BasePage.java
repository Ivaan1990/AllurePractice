package ru.aplana.autotests.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public boolean isElementPresent(WebElement element){
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException ex){
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }

}