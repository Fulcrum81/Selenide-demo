import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.qatools.properties.PropertyLoader;
import vadim.constants.UserData;
import vadim.pages.LoginPage;

public class LoginTest extends TestBase {
    private UserData userData;

    @BeforeClass
    public void populateProperties() {
        userData = PropertyLoader.newInstance().populate(UserData.class);
    }

    @Test
    public void loginSuccessMessageTest() {
        LoginPage.login(userData.getCorrectLogin(), userData.getCorrectPassword());
        LoginPage.validateSuccessMessageTextAndColor("Vadim Zubovich");
    }

    @Test
    public void loginErrorMessageTest() {
        LoginPage.login(userData.getCorrectLogin(), "QWERTY");
        LoginPage.validateErrorMessageTextAndColor();
    }

    @Test
    public void loginFlakyTest() {
        LoginPage.login(userData.getCorrectLogin(), "QWERTY");
        LoginPage.flakyValidation();
    }
}
