package vadim.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainMenu {
    private static String rubberDucksLink = "//nav[@id='site-menu']//a[text()='Rubber Ducks']";

    @Step("Navigating to Rubber Ducks page")
    public static void goToRubberDucksPage() {
        $x(rubberDucksLink).click();
    }
}
