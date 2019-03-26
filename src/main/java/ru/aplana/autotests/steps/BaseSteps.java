package ru.aplana.autotests.steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.aplana.autotests.util.TestProperties;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();
    private static HashMap<String, String> variables = new HashMap<String, String>();

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp(){
        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
        }
        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void setDown(){
        driver.quit();
    }

    public static String getVariable(String key){
        return variables.get(key);
    }

    public static void setVariables(String key, String value) {
        variables.put(key, value);
    }   
}