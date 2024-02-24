import org.testng.annotations.Test;
import vadim.pages.DuckDetailsPage;
import vadim.pages.MainMenu;
import vadim.pages.RubberDucksPage;

import static vadim.constants.Ducks.BLUE_DUCK;
import static vadim.constants.Ducks.RED_DUCK;

public class StockAmountTest extends TestBase {
    @Test
    public void outOfStockItemAddToCartDisabledTest() {
        MainMenu.goToRubberDucksPage();
        RubberDucksPage.selectDuck(BLUE_DUCK);
        DuckDetailsPage.verifyStockStatusIsSoldOut();
        DuckDetailsPage.verifyAddToCartButtonIsDisabled();
    }
}
