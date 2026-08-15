package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.testdata.TestData;

import static tests.testdata.TestData.*;

public class ValidationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void emptyLastNameTest(){

        registrationPage.openPage()
                .removeAdBanners()
                .setFirstName(testData.firstName)
                .submit()
                .checkValidation();
    }

    @Test
    void wrongEmailForm(){

        registrationPage.openPage()
                .removeAdBanners()
                .setUserEmail(incorrectEmail)
                .submit()
                .checkValidation();
    }

    @Test
    void shortMobileNumber(){

        registrationPage.openPage()
                .removeAdBanners()
                .setUserNumber(incorrectPhoneNumber)
                .submit()
                .checkValidation();
    }

}
