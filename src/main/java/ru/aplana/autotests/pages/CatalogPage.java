package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.aplana.autotests.steps.BaseSteps;

import java.util.List;

public class CatalogPage extends BasePage {
    @FindBy(xpath = "//*[@class=\"products-grid\"]//a[@title]/ancestor::li")
    List<WebElement> productCollection;


    public void addProduct(String productName){
        String price = getProduct(productName)
                .findElement(By.xpath("//*[@class='products-grid']//li//span[@class='price']"))
                .getText().replaceAll("\\D", "");
        BaseSteps.setVariables(productName, price);
        getProduct(productName).findElement(By.xpath("//*[@class='products-grid']//li//span[text()='Заказать']/..")).click();
    }

    public WebElement getProduct(String productName){
        for(WebElement item : productCollection){
            if (item.findElement(By.xpath(".//a[@title]")).getAttribute("title").equals(productName)){
                return item;
            }
        }
        Assert.fail("Не найден продукт с наименованием" + productName);
        return null;
    }
}