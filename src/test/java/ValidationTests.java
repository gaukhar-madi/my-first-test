import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class ValidationTests extends TestBase {


    @Test
    void emptyLastNameTest(){

        open("/automation-practice-form");
        // заполнить имя
        $("[id=firstName]").setValue(firstName);
        $("#submit").click();

        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);
        // проверить что поля формы красные
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }
    @Test
    void wrongEmailForm(){

        open("/automation-practice-form");
        // вводим email без точки и доменной зоны
        $("[id=userEmail]").setValue(incorrectEmail);
        $("#submit").click();
        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);
        // проверить что поля формы красные
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void shortMobileNumber(){

        open("/automation-practice-form");
        // вводим номер телефона < 10 цифр
        $("[id=userNumber]").setValue(incorrectPhoneNumber);
        $("#submit").click();
        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);
        // проверить что поля формы красные
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

}
