import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.PracticeFormTestData;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends BaseTest {


    @Test
    @DisplayName("Successful registration")
    void submitFullFillFormTest() {
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Fill registration form", () -> {
            registrationPage.removeBanners()
                    .typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .setGender(testData.gender)
                    .typeUserPhoneNumber(testData.mobilePhoneNumber)
                    .setDateOfBirth(testData.birthDay, testData.birthMonth[0], testData.birthYear)
                    .setSubject(testData.subject)
                    .setHobbies(testData.hobbies)
                    .uploadPicture(testData.uploadPicture)
                    .typeCurrentAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city)
                    .submitForm();
        });
        step("Check registration form results", () -> {
            registrationPage.checkResultCondition(visible)
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.mobilePhoneNumber)
                    .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth[1] + " " + testData.birthYear)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobbies)
                    .checkResult("Picture", testData.uploadPicture)
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " + testData.city)
                    .closeResult()
                    .checkResultCondition(disappear);
        });
    }

    @Test
    @DisplayName("Successful registration with required fields")
    void submitFormWithRequiredFieldsTest() {
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Fill registration form", () -> {
            registrationPage.removeBanners()
                    .typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .setGender(testData.gender)
                    .typeUserPhoneNumber(testData.mobilePhoneNumber)
                    .submitForm();

        });
        step("Check registration form results", () -> {
            registrationPage.checkResultCondition(visible)
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.mobilePhoneNumber)
                    .closeResult()
                    .checkResultCondition(disappear);
        });
    }

    @Test
    @DisplayName("Failed registration without required first name")
    void submitFormWithoutRequiredFirstName() {
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Fill registration form", () -> {
            registrationPage.removeBanners()
                    .typeLastName(testData.lastName)
                    .setGender(testData.gender)
                    .typeUserPhoneNumber(testData.mobilePhoneNumber)
                    .submitForm();

        });
        step("Check form error text", () -> {
            registrationPage.checkFormError(testData.formError);
        });
    }

    @Test
    @DisplayName("Failed registration without required last name")
    void submitFormWithoutRequiredLastName() {
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Fill registration form", () -> {
            registrationPage.removeBanners()
                    .typeFirstName(testData.firstName)
                    .setGender(testData.gender)
                    .typeUserPhoneNumber(testData.mobilePhoneNumber)
                    .submitForm();
        });
        step("Check form error text", () -> {
            registrationPage.checkFormError(testData.formError);
        });
    }

    @Test
    @DisplayName("Failed registration without required user phone")
    void submitFormWithoutRequiredUserPhone() {
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Fill registration form", () -> {
            registrationPage.removeBanners()
                    .typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .setGender(testData.gender)
                    .submitForm();
        });
        step("Check form error text", () -> {
            registrationPage.checkFormError(testData.formError);
        });
    }

    @Test
    @DisplayName("Failed registration without uncorrected user phone")
    void submitFormWithUncorrectedUserPhone() {
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Fill registration form", () -> {
            registrationPage.removeBanners()
                    .typeLastName(testData.lastName)
                    .setGender(testData.gender)
                    .typeUserPhoneNumber(testData.uncorrectMobilePhoneNumber)
                    .submitForm();
        });
        step("Check form error text", () -> {
            registrationPage.checkFormError(testData.formError);
        });
    }
}
