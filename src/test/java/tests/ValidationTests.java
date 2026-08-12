package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.*;

public class ValidationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void emptyLastNameTest(){

        registrationPage.openPage()
                .removeAdBanners()
                .setFirstName(firstName)
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
