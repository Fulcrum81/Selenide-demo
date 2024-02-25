import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import vadim.ScreenshotListener;
import vadim.enums.Browser;
import vadim.enums.OperatingSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

@Listeners(ScreenshotListener.class)
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
    public void teardown(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            File screenshot = Selenide.screenshot(OutputType.FILE);
//            try {
//                Allure.addAttachment(result.getTestName() + " screenshot", new FileInputStream(screenshot));
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
        WebDriverRunner.getWebDriver().quit();
    }
}
