package ru.aplana.autotests.util;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.aplana.autotests.steps.BaseSteps;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(final Failure failure) throws Exception{
        takescreenchot();
        super.testFailure(failure);
    }

    @Attachment(type="image/png", value="Скриншот при ошибке")
    public static byte[] takescreenchot(){
        return ((TakesScreenshot)BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);

    }
}