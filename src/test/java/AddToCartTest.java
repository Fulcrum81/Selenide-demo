import org.testng.annotations.Test;
import vadim.enums.DuckSize;
import vadim.pages.CartSection;
import vadim.pages.DuckDetailsPage;
import vadim.pages.MainMenu;
import vadim.pages.RubberDucksPage;

import static vadim.constants.Ducks.*;

public class AddToCartTest extends TestBase {

    @Test
    public void cartQuantityAddOneDuckTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(PURPLE_DUCK);
        DuckDetailsPage.addToCart();
        CartSection.validateQuantity(1);
    }

    @Test
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
    public void cartQuantityAddOneDuckSizeSelectionTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(YELLOW_DUCK);
        DuckDetailsPage.selectSize(DuckSize.Medium);
        DuckDetailsPage.addToCart();
        CartSection.validateQuantity(1);
    }

    @Test
    public void priceAddOneDuckTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(RED_DUCK);
        double redDuckPrice = DuckDetailsPage.getPrice();
        DuckDetailsPage.addToCart();
        CartSection.validateAmount(redDuckPrice);
    }
}
