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
import tests.testdata.TestData;

import static tests.testdata.TestData.*;

@Feature("Формы на demoqa.com")
@Story("Валидация формы регистрации")
@Owner("gaukhar")
@Tag("validation")
@Severity(SeverityLevel.NORMAL)
public class ValidationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Валидация: не заполнена фамилия")
    void emptyLastNameTest(){

        registrationPage.openPage()
                .removeAdBanners()
                .setFirstName(testData.firstName)
                .submit()
                .checkValidation();
    }

    @Test
    @DisplayName("Валидация: некорректный email")
    void wrongEmailForm(){

        registrationPage.openPage()
                .removeAdBanners()
                .setUserEmail(incorrectEmail)
                .submit()
                .checkValidation();
    }

    @Test
    @DisplayName("Валидация: слишком короткий номер телефона")
    void shortMobileNumber(){

        registrationPage.openPage()
                .removeAdBanners()
                .setUserNumber(incorrectPhoneNumber)
                .submit()
                .checkValidation();
    }

}
