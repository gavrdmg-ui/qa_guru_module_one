import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.PracticeFormTestData.*;

public class PracticeFormTest extends BaseTest {

    @Test
    void submitFullFillFormTest() {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobilePhoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies.get(0))).click();
        $("#hobbiesWrapper").$(byText(hobbies.get(1))).click();
        $("#uploadPicture").uploadFromClasspath(uploadPicture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).scrollTo().click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").scrollTo().click();

        $("#resultModal").shouldBe(visible);
        $x("//tr[td[text()=\"Student Name\"]]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("//tr[td[text()=\"Student Email\"]]/td[2]").shouldHave(text(userEmail));
        $x("//tr[td[text()=\"Gender\"]]/td[2]").shouldHave(text(gender));
        $x("//tr[td[text()=\"Mobile\"]]/td[2]").shouldHave(text(mobilePhoneNumber));
        $x("//tr[td[text()=\"Date of Birth\"]]/td[2]").shouldHave(text(birthDay + " " + months.get(birthMonth) + " " + birthYear));
        $x("//tr[td[text()=\"Subjects\"]]/td[2]").shouldHave(text(subject));
        $x("//tr[td[text()=\"Hobbies\"]]/td[2]").shouldHave(text(hobbies.get(0) +", "+hobbies.get(1)));
        $x("//tr[td[text()=\"Picture\"]]/td[2]").shouldHave(text(uploadPicture));
        $x("//tr[td[text()=\"Address\"]]/td[2]").shouldHave(text(currentAddress));
        $x("//tr[td[text()=\"State and City\"]]/td[2]").shouldHave(text(state + " " + city));

        $("#closeModal").click();

        $("#resultModal").shouldBe(disappear);
    }

    @Test
    void submitFormWithRequiredFieldsTest() {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobilePhoneNumber);
        $("#submit").scrollTo().click();

        $("#resultModal").shouldBe(visible);
        $x("//tr[td[text()=\"Student Name\"]]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("//tr[td[text()=\"Gender\"]]/td[2]").shouldHave(text(gender));
        $x("//tr[td[text()=\"Mobile\"]]/td[2]").shouldHave(text(mobilePhoneNumber));

        $("#closeModal").click();

        $("#resultModal").shouldBe(disappear);
    }

    @Test
    void submitFormWithotRequiredFirstName() {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobilePhoneNumber);
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text(formError));
    }

    @Test
    void submitFormWithoutRequiredLastName() {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue(firstName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobilePhoneNumber);
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text(formError));
    }

    @Test
    void submitFormWithotRequiredUserPhone() {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text(formError));
    }

    @Test
    void submitFormWithUncorrectedUserPhone() {
        open("/one-page-form/automation-practice-form.html");
        $("#promoCta").shouldBe(visible);
        $("[aria-label='Close'][type='button']").click();
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(uncorrectMobilePhoneNumber);
        $("#submit").scrollTo().click();

        $("#formError").shouldBe(visible);
        $("#formError").shouldHave(text(formError));
    }
}
