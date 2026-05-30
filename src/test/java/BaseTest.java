import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    static void setUp()
    {
        Configuration.baseUrl="https://qa-guru.github.io";
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen=false;
    }

    @AfterEach
    void tearDown()
    {
        closeWebDriver();
    }
}
