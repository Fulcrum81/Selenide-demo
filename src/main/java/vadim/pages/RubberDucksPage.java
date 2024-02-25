package vadim.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebElementCondition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;

public class RubberDucksPage {
    private static String purpleDuck = "img[alt='%s']";

    @Step("Selecting a duck")
    public static void selectDuck(String duckToClick) {
        $(String.format(purpleDuck, duckToClick)).click();
    }
}
