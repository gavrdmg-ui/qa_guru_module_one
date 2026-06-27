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
        $(".react-datepicker__week").$(byText(birthDay)).click();
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobilePhoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthDay + " " + months.get(birthMonth) + " " + birthYear));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies.get(0) + ", " + hobbies.get(1)));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(uploadPicture));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));

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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobilePhoneNumber));

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
