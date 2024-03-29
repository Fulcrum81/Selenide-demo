package vadim.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static vadim.constants.RgbaColor.LIGHT_GREEN;
import static vadim.constants.RgbaColor.LIGHT_RED;

public class LoginPage {
    private static String usernameInput = "[name='email']";
    private static String passwordInput = "[name='password']";
    private static String loginButton = "[name='login']";
    private static String successMessage = ".notice.success";
    private static String errorMessage = ".notice.errors";

    private static String successMessageText = "You are now logged in as %s";
    private static String errorMessageText = "Wrong password or the account is disabled, or does not exist";

    @Step("Attempting login")
    public static void login(String username, String password) {
        $(usernameInput).sendKeys(username);
        $(passwordInput).sendKeys(password);
        $(loginButton).click();
    }

    @Step("Validating successful login message")
    public static void validateSuccessMessageTextAndColor(String userFullName) {
        $(successMessage)
                .shouldHave(text(String.format(successMessageText, userFullName)))
                .shouldHave(cssValue("background-color", LIGHT_GREEN));
    }

    @Step("Validating login error message")
    public static void validateErrorMessageTextAndColor() {
        $(errorMessage)
                .shouldHave(text(errorMessageText))
                .shouldHave(cssValue("background-color", LIGHT_RED));
    }

    @Step("Flaky validation that fails at random")
    public static void flakyValidation() {
        if (System.currentTimeMillis() % 2 == 0) {
            $(errorMessage).shouldBe(selected);
        }
    }
}
