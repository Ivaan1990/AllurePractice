import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.aplana.autotests.steps.BaseSteps;
import ru.aplana.autotests.steps.CartSteps;
import ru.aplana.autotests.steps.CatalogSteps;
import ru.aplana.autotests.steps.MainSteps;

public class ShopTest  extends BaseSteps {

    @Test
    @DisplayName("Добавление в корзину")
    public void testMethod(){
        MainSteps mainSteps = new MainSteps();
        CatalogSteps catalogSteps = new CatalogSteps();
        CartSteps cartSteps = new CartSteps();

        mainSteps.stepSelectMenuItem("Меню доставки");
        mainSteps.stepSelectMenuItem("Выпечка");
        catalogSteps.stepAddProduct("Пичча нон с бараниной");

        mainSteps.stepSelectMenuItem("Меню доставки");
        mainSteps.stepSelectMenuItem("Бургеры и шаурма");
        catalogSteps.stepAddProduct("Шаурма с курицей");

        mainSteps.stepSelectMenuItem("Меню доставки");
        mainSteps.stepSelectMenuItem("Плов");
        catalogSteps.stepAddProduct("Плов Чайханский");

        mainSteps.stepGoToCart();
        cartSteps.stepCheckProduct("Пичча нон с бараниной");
        cartSteps.stepCheckProduct("Шаурма с курицей");
        cartSteps.stepCheckProduct("Плов Чайханский");

        Integer expectedAmount = Integer.parseInt(getVariable("Пичча нон с бараниной")) +
                Integer.parseInt(getVariable("Шаурма с курицей")) +
                Integer.parseInt(getVariable("Плов Чайханский"));
        cartSteps.stepCheckTotalAmount(expectedAmount.toString());

    }
}
