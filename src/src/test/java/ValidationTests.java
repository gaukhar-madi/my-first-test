import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class ValidationTests extends TestBase {


    @Test
    void emptyLastNameTest(){

        // заполнить имя
        $("[id=firstName]").setValue("Tom");

        // CLICK SUBMIT BUTTON

        SelenideElement button = $("#submit");
        button.click();

        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);

        // проверить что поля формы красные
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userForm").shouldHave(cssClass("was-validated"));


    }
    @Test
    void wrongEmailForm(){

        // вводим email без точки и доменной зоны
        $("[id=userEmail]").setValue("michaelthomas@mail");

        // CLICK SUBMIT BUTTON

        SelenideElement button = $("#submit");
        button.click();
        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);

        // проверить что поля формы красные
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userForm").shouldHave(cssClass("was-validated"));
    }

    @Test
    void longMobileNumber(){


        // вводим номер телефона < 10 цифр
        $("[id=userNumber]").setValue("777000555");

        // Submit
        SelenideElement button = $("#submit");
        button.click();

        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);

        // проверить что поля формы красные
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userForm").shouldHave(cssClass("was-validated"));

    }

}
