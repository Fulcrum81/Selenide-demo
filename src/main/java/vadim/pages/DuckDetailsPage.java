package vadim.pages;

import vadim.enums.DuckSize;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DuckDetailsPage {
    private static String addToCartButton = ".quantity>button[type='submit']";
    private static String sizeSelect = "[name='options[Size]']";
    private static String priceInfo = "[itemprop='price']";
    private static String stockStatusLabel = ".stock-status .value";

    public static void addToCart() {
        int qty = Integer.parseInt(CartSection.getCartCounter().getText());
        $(addToCartButton).click();
        CartSection.getCartCounter().shouldHave(text(String.valueOf(++qty)));
    }

    public static void selectSize(DuckSize size) {
        $(sizeSelect).selectOptionByValue(size.toString());
    }

    public static double getPrice() {
        String price = $(priceInfo).getText();
        price = price.replace("$", "");

        return Double.parseDouble(price);
    }

    public static void verifyStockStatusIsSoldOut() {
        $(stockStatusLabel).shouldHave(text("Temporary sold out"));
    }

    public static void verifyAddToCartButtonIsDisabled() {
        $(addToCartButton).shouldBe(disabled);
    }

}
