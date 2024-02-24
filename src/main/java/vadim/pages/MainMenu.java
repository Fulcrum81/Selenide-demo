package vadim.pages;

import static com.codeborne.selenide.Selenide.$x;

public class MainMenu {
    private static String rubberDucksLink = "//nav[@id='site-menu']//a[text()='Rubber Ducks']";

    public static void goToRubberDucksPage() {
        $x(rubberDucksLink).click();
    }
}
