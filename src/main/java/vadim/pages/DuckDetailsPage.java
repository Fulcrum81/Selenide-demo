package vadim.pages;

import io.qameta.allure.Step;
import vadim.enums.DuckSize;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DuckDetailsPage {
    private static String addToCartButton = ".quantity>button[type='submit']";
    private static String sizeSelect = "[name='options[Size]']";
    private static String priceInfo = "[itemprop='price']";
    private static String stockStatusLabel = ".stock-status .value";

    @Step("Clicking Add to cart button")
    public static void addToCart() {
        int qty = Integer.parseInt(CartSection.getCartCounter().getText());
        $(addToCartButton).click();
        CartSection.getCartCounter().shouldHave(text(String.valueOf(++qty)));
    }

    @Step("Selecting duck size in dropdown")
    public static void selectSize(DuckSize size) {
        $(sizeSelect).selectOptionByValue(size.toString());
    }

    /** Not a business step, so no @Step annotation necessary **/
    public static double getPrice() {
        String price = $(priceInfo).getText();
        price = price.replace("$", "");

        return Double.parseDouble(price);
    }

    @Step("Validating that the item is sold out")
    public static void verifyStockStatusIsSoldOut() {
        $(stockStatusLabel).shouldHave(text("Temporary sold out"));
    }

    @Step("Verifying that Add to cart button is disabled")
    public static void verifyAddToCartButtonIsDisabled() {
        $(addToCartButton).shouldBe(disabled);
    }

}
