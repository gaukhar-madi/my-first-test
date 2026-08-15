package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

import tests.testdata.TestData;

public class MyFirstFormTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
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
