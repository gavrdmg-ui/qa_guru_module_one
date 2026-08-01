package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultModalComponent pageResults = new ResultModalComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement subjectsContainer = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement title = $(".practice-form-wrapper");
    private final SelenideElement formErrorMessage = $("#formError");

    @Step ("Open registration page /one-page-form/automation-practice-form.html")
    public RegistrationPage openPage() {
        open("/one-page-form/automation-practice-form.html");
        title.shouldHave(text("Student Registration Form"));

        return this;
    }
    @Step("Remove Banners")
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Type first name {value}")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Type last name \"{value}\"")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Type email \"{value}\"")
    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    @Step("Choose gender \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }
    @Step("Type phone number \"{value}\"")
    public RegistrationPage typeUserPhoneNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    @Step("Type birth date \"{day}\" \"{month}\" \"{year}\"")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }
    @Step("Select subject \"{value}\"")
    public RegistrationPage setSubject(String value) {
        subjectsContainer.setValue(value).pressEnter();

        return this;
    }
    @Step("Select hobbies \"{value}\"")
    public RegistrationPage setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }
    @Step("Upload picture \"{path}\"")
    public RegistrationPage uploadPicture(String path) {
        uploadPicture.uploadFromClasspath(path);

        return this;
    }
    @Step("Type address \"{value}\"")
    public RegistrationPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public void setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

    }

    public void setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

    }
    @Step("Select city and state \"{state}\" \"{city}\"")
    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }
    @Step("Submit form")
    public RegistrationPage submitForm() {
        submitButton.scrollTo().click();

        return this;
    }
    @Step("Check that result field has condition \"{condition}\"")
    public RegistrationPage checkResultCondition(Condition condition) {
        pageResults.checkState(condition);

        return this;
    }
    @Step("Check that field \"{key}\" has result \"{value}\"")
    public RegistrationPage checkResult(String key, String value) {
        pageResults.checkField(key, value);

        return this;
    }
    @Step("Close result field")
    public RegistrationPage closeResult() {
        pageResults.closeTable();

        return this;
    }
    @Step("Check that form error has correct text \"{value}\"")
    public void checkFormError(String value) {
        formErrorMessage.shouldHave(text(value));

    }
}
