import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import pages.RegistrationPage;
import testdata.PracticeFormTestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    public PracticeFormTestData testData;

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://qa-guru.github.io";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @BeforeEach
    void PrepareTestData() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        testData = new PracticeFormTestData();
    }
}
