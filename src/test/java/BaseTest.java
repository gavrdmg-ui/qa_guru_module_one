import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import testdata.PracticeFormTestData;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    public PracticeFormTestData testData;

    @BeforeAll
    static void setUp() {
        Configuration.browser=System.getProperty("browser","chrome");
        Configuration.browserVersion=System.getProperty("browserVersion","149.0");
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.headless= Boolean.parseBoolean(System.getProperty("headless","true"));
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = System.getProperty("baseUrl","https://qa-guru.github.io");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(List.of("--disable-dev-shm-usage", "--no-sandbox"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = System.getProperty("remoteURL");
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.attachAsText("Some file", "Some content");
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

    @BeforeEach
    void PrepareTestData() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        testData = new PracticeFormTestData();
    }
}
