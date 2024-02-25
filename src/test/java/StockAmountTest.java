import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import vadim.pages.DuckDetailsPage;
import vadim.pages.MainMenu;
import vadim.pages.RubberDucksPage;

import static vadim.constants.Ducks.BLUE_DUCK;
import static vadim.constants.Ducks.RED_DUCK;

@Epic("Catalog")
@Feature("Adding goods to cart")
public class StockAmountTest extends TestBase {
    @Test
    @Description("Validate that the add to cart button is disabled when item is out of stock")
    @Story("Out of stock items")
    public void outOfStockItemAddToCartDisabledTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(BLUE_DUCK);
        DuckDetailsPage.verifyStockStatusIsSoldOut();
        DuckDetailsPage.verifyAddToCartButtonIsDisabled();
    }
}
