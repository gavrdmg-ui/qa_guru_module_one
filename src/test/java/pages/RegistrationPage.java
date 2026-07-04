package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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


    public RegistrationPage openPage() {
        open("/one-page-form/automation-practice-form.html");
        title.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage typeUserPhoneNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsContainer.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        uploadPicture.uploadFromClasspath(path);

        return this;
    }

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

    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.scrollTo().click();

        return this;
    }

    public RegistrationPage checkResultCondition(Condition condition) {
        pageResults.checkState(condition);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        pageResults.checkField(key, value);

        return this;
    }

    public RegistrationPage closeResult() {
        pageResults.closeTable();

        return this;
    }

    public void checkFormError(String value) {
        formErrorMessage.shouldHave(text(value));

    }
}
