package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

import tests.testdata.TestData;

@Feature("Формы на demoqa.com")
@Owner("gaukhar")
@Tag("form")
public class MyFirstFormTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @Story("Форма практики регистрации студента")
    @DisplayName("Заполнение полной формы регистрации")
    @Severity(SeverityLevel.CRITICAL)
    void fillFullFormTest() {

        registrationPage.openPage()
                .removeAdBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.birthYear, testData.birthMonth, testData.birthDay)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();


        registrationPage.checkResultModalAppears()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);


    }

    @Test
    @Story("Форма Text Box")
    @DisplayName("Заполнение короткой формы Text Box")
    @Severity(SeverityLevel.NORMAL)
    void fillShortFormTest(){

        textBoxPage.openPage()
                .removeAdBanners()
                .setFullName(testData.firstName + " " + testData.lastName)
                .setEmail(testData.userEmail)
                .setCurrentAddress(testData.currentAddress)
                .setPermanentAddress(testData.permanentAddress)
                .submit()
                .checkResult(testData.firstName + " " + testData.lastName, testData.userEmail, testData.currentAddress, testData.permanentAddress);
    }
}
