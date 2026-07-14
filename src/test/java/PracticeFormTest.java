import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.PracticeFormTestData;

import static com.codeborne.selenide.Condition.*;

public class PracticeFormTest extends BaseTest {

    public PracticeFormTestData testData;

    @BeforeEach
    void PrepareTestData() {
        testData = new PracticeFormTestData();
    }

    @Test
    void submitFullFillFormTest() {
        registrationPage.openPage()
                .removeBanners()
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
                .submitForm()
                .checkResultCondition(visible)
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
    }

    @Test
    void submitFormWithRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typeUserPhoneNumber(testData.mobilePhoneNumber)
                .submitForm()
                .checkResultCondition(visible)
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.mobilePhoneNumber)
                .closeResult()
                .checkResultCondition(disappear);
    }

    @Test
    void submitFormWithoutRequiredFirstName() {
        registrationPage.openPage()
                .removeBanners()
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typeUserPhoneNumber(testData.mobilePhoneNumber)
                .submitForm()
                .checkFormError(testData.formError);
    }

    @Test
    void submitFormWithoutRequiredLastName() {
        registrationPage.openPage()
                .removeBanners()
                .typeFirstName(testData.firstName)
                .setGender(testData.gender)
                .typeUserPhoneNumber(testData.mobilePhoneNumber)
                .submitForm()
                .checkFormError(testData.formError);
    }

    @Test
    void submitFormWithoutRequiredUserPhone() {
        registrationPage.openPage()
                .removeBanners()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .submitForm()
                .checkFormError(testData.formError);
    }

    @Test
    void submitFormWithUncorrectedUserPhone() {
        registrationPage.openPage()
                .removeBanners()
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typeUserPhoneNumber(testData.uncorrectMobilePhoneNumber)
                .submitForm()
                .checkFormError(testData.formError);
    }
}
