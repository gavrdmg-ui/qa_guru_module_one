import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static testdata.PracticeFormTestData.*;

public class PracticeFormTest extends BaseTest {

    @Test
    void submitFullFillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(gender)
                .typeUserPhoneNumber(mobilePhoneNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobbies(hobbies.get(0))
                .setHobbies(hobbies.get(1))
                .uploadPicture(uploadPicture)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm()
                .checkResultCondition(visible)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobilePhoneNumber)
                .checkResult("Date of Birth", birthDay + " " + months.get(birthMonth) + " " + birthYear)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies.get(0) + ", " + hobbies.get(1))
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city)
                .closeResult()
                .checkResultCondition(disappear);
    }

    @Test
    void submitFormWithRequiredFieldsTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserPhoneNumber(mobilePhoneNumber)
                .submitForm()
                .checkResultCondition(visible)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobilePhoneNumber)
                .closeResult()
                .checkResultCondition(disappear);
    }

    @Test
    void submitFormWithoutRequiredFirstName() {
        registrationPage.openPage()
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserPhoneNumber(mobilePhoneNumber)
                .submitForm()
                .checkFormError(formError);
    }

    @Test
    void submitFormWithoutRequiredLastName() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .setGender(gender)
                .typeUserPhoneNumber(mobilePhoneNumber)
                .submitForm()
                .checkFormError(formError);
    }

    @Test
    void submitFormWithoutRequiredUserPhone() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .submitForm()
                .checkFormError(formError);
    }

    @Test
    void submitFormWithUncorrectedUserPhone() {
        registrationPage.openPage()
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserPhoneNumber(uncorrectMobilePhoneNumber)
                .submitForm()
                .checkFormError(formError);
    }
}
