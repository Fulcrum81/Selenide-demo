package vadim.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartSection {
    private static String section = "#cart";
    private static String quantity = "span.quantity";

    private static String totalPrice = "#cart .formatted_value";

    @Step("Validating quantity in the cart")
    public static void validateQuantity(int q) {
        $(quantity).shouldHave(text(String.valueOf(q)));
    }

    /** Not a business step, so no @Step annotation necessary **/
    public static SelenideElement getCartCounter() {
        return $(quantity);
    }

    @Step("Validating total amount in cart")
    public static void validateAmount(double expectedAmount) {
        String actualAmountText = $(totalPrice).getText();
        actualAmountText = actualAmountText.replace("$", "");

        double actualAmount = Double.parseDouble(actualAmountText);

        Assert.assertEquals(actualAmount, expectedAmount);
    }
}
