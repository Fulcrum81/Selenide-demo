import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import vadim.enums.Browser;
import vadim.enums.OperatingSystem;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));
        OperatingSystem os = OperatingSystem.valueOf(System.getProperty("os", "windows"));

        switch (browser) {
            case chrome ->  caps.setBrowserName("chrome");
            case firefox -> caps.setBrowserName("firefox");
        }

        switch (os) {
            case windows -> caps.setPlatform(Platform.WINDOWS);
            case ubuntu -> caps.setPlatform(Platform.LINUX);
        }

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.249.1:4444/wd/hub"),caps);

        WebDriverRunner.setWebDriver(driver);

        open("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
