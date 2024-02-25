import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import vadim.enums.DuckSize;
import vadim.pages.CartSection;
import vadim.pages.DuckDetailsPage;
import vadim.pages.MainMenu;
import vadim.pages.RubberDucksPage;

import static vadim.constants.Ducks.*;

@Epic("Cart")
@Feature("Adding goods to cart")
public class AddToCartTest extends TestBase {

    @Test
    @Description("Validate cart counter after adding one duck to cart")
    @Story("Cart quantity counter")
    public void cartQuantityAddOneDuckTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(PURPLE_DUCK);
        DuckDetailsPage.addToCart();
        CartSection.validateQuantity(1);
    }

    @Test
    @Description("Validate cart counter after adding three ducks to cart")
    @Story("Cart quantity counter")
    public void cartQuantityAddThreeDucksTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(PURPLE_DUCK);
        DuckDetailsPage.addToCart();
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(RED_DUCK);
        DuckDetailsPage.addToCart();
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(BLUE_DUCK);
        DuckDetailsPage.addToCart();
        CartSection.validateQuantity(3);
    }

    @Test
    @Description("Validate cart counter after adding one duck with extra size cost to cart")
    @Story("Cart quantity counter")
    public void cartQuantityAddOneDuckSizeSelectionTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(YELLOW_DUCK);
        DuckDetailsPage.selectSize(DuckSize.Medium);
        DuckDetailsPage.addToCart();
        CartSection.validateQuantity(1);
    }

    @Test
    @Description("Validate cart price after adding one duck to cart")
    @Story("Cart price counter")
    public void priceAddOneDuckTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(RED_DUCK);
        double redDuckPrice = DuckDetailsPage.getPrice();
        DuckDetailsPage.addToCart();
        CartSection.validateAmount(redDuckPrice);
    }
}
