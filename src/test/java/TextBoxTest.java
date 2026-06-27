import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TextBoxTestData.*;

public class TextBoxTest extends BaseTest{

    @Test
    void submitFormWithOneField ()
    {
        open("/one-page-form/text-box.html");
        $("#userName").setValue(userName);
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#name").shouldHave(text(userName));
    }

    @Test
    void submitFormWithInvalidEMail ()
    {
        open("/one-page-form/text-box.html");
        $("#userEmail").setValue(invalidUserEmail);
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color","rgb(51, 93, 255)"));
    }
}

