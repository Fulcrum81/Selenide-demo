import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.qatools.properties.PropertyLoader;
import vadim.constants.UserData;
import vadim.pages.LoginPage;

@Epic("Authorization and authentication")
@Feature("Login screen")
public class LoginTest extends TestBase {
    private UserData userData;

    @BeforeClass
    public void populateProperties() {
        userData = PropertyLoader.newInstance().populate(UserData.class);
    }

    @Test
    @Description("Validate success message text after login with correct credentials")
    @Story("Login message")
    public void loginSuccessMessageTest() {
        LoginPage.login(userData.getCorrectLogin(), userData.getCorrectPassword());
        LoginPage.validateSuccessMessageTextAndColor("Vadim Zubovich");
    }

    @Test
    @Description("Validate error message text after login with incorrect password")
    @Story("Login message")
    public void loginErrorMessageTest() {
        LoginPage.login(userData.getCorrectLogin(), "QWERTY");
        LoginPage.validateErrorMessageTextAndColor();
    }

    @Test
    @Description("Flaky test that fails at random")
    public void loginFlakyTest() {
        LoginPage.login(userData.getCorrectLogin(), "QWERTY");
        LoginPage.flakyValidation();
    }
}
