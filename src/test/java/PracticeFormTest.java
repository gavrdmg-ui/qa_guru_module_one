import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends BaseTest{

    @Test
    void submitFullFillFormTest ()
    {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testov");
        $("#userEmail").setValue("testing@mail.com");
        $("[type='radio'][value='Male']").click();
        $("#userNumber").setValue("7923858192");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("Cat.jpg");
        $("#currentAddress").setValue("Улица Пушкина, дом Колотушкина, квартира Вампиров, №3");
        $("#state").click();
        $("#stateCity-wrapper").shouldBe(visible);
        $x("//div[@class='state-city-option'] [text()=\"Uttar Pradesh\"]").scrollTo().click();
        $("#city").click();
        $x("//div[@class='state-city-option'] [text()=\"Lucknow\"]").click();
        $("#submit").scrollTo().click();

        $("#resultModal").shouldBe(visible);
        $x("//tr[td[text()=\"Student Name\"]]/td[2]").shouldHave(text("Test Testov"));
        $x("//tr[td[text()=\"Student Email\"]]/td[2]").shouldHave(text("testing@mail.com"));
        $x("//tr[td[text()=\"Gender\"]]/td[2]").shouldHave(text("Male"));
        $x("//tr[td[text()=\"Mobile\"]]/td[2]").shouldHave(text("7923858192"));
        $x("//tr[td[text()=\"Date of Birth\"]]/td[2]").shouldHave(text("27 Aug 1999"));
        $x("//tr[td[text()=\"Subjects\"]]/td[2]").shouldHave(text("Computer Science"));
        $x("//tr[td[text()=\"Hobbies\"]]/td[2]").shouldHave(text("Sports, Music"));
        $x("//tr[td[text()=\"Picture\"]]/td[2]").shouldHave(text("Cat.jpg"));
        $x("//tr[td[text()=\"Address\"]]/td[2]").shouldHave(text("Улица Пушкина, дом Колотушкина, квартира Вампиров, №3"));
        $x("//tr[td[text()=\"State and City\"]]/td[2]").shouldHave(text("Uttar Pradesh Lucknow"));

        $("#closeModal").click();

        $("#resultModal").shouldBe(disappear);
    }

    @Test
    void submitFormWithRequiredFieldsTest()
    {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testov");
        $("[type='radio'][value='Male']").click();
        $("#userNumber").setValue("7923858192");
        $("#submit").scrollTo().click();

        $("#resultModal").shouldBe(visible);
        $x("//tr[td[text()=\"Student Name\"]]/td[2]").shouldHave(text("Test Testov"));
        $x("//tr[td[text()=\"Gender\"]]/td[2]").shouldHave(text("Male"));
        $x("//tr[td[text()=\"Mobile\"]]/td[2]").shouldHave(text("7923858192"));

        $("#closeModal").click();

        $("#resultModal").shouldBe(disappear);
    }
    @Test
    void submitFormWithotRequiredFirstName()
    {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#lastName").setValue("Testov");
        $("[type='radio'][value='Male']").click();
        $("#userNumber").setValue("7923858192");
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
    @Test
    void submitFormWithotRequiredLastName()
    {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue("Test");
        $("[type='radio'][value='Male']").click();
        $("#userNumber").setValue("7923858192");
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
    @Test
    void submitFormWithotRequiredUserPhone()
    {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testov");
        $("[type='radio'][value='Male']").click();
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
    @Test
    void submitFormWithUncorrectedUserPhone()
    {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#lastName").setValue("Testov");
        $("[type='radio'][value='Male']").click();
        $("#userNumber").setValue("7923");
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
}
