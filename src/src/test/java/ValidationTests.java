import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class ValidationTests {


    @BeforeEach
    void setUp(){

        Configuration.browserSize = "1920x1080";

        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void EmptyLastNameTest(){

        // LEAVE LAST NAME EMPTY

        // заполнить имя
        $("[id=firstName]").setValue("Tom");

        // CLICK SUBMIT BUTTON

        SelenideElement button = $("#submit");

        // прокруить страницу пока не будет видна кнопка
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );

        // кликнуть на кнопку Submit
        executeJavaScript("arguments[0].click();", button);

        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);

        // проверить что поля формы красные
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


    }
    @Test
    void WrongEmailForm(){

        // ВВЕСТИ НЕВЕРНЫЙ email

        // вводим email без точки и доменной зоны
        $("[id=userEmail]").setValue("michaelthomas@mail");

        // CLICK SUBMIT BUTTON

        SelenideElement button = $("#submit");

        // прокруить страницу пока не будет видна кнопка
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );

        // кликнуть на кнопку Submit
        executeJavaScript("arguments[0].click();", button);

        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);

        // проверить что поля формы красные
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void LongMobileNumber(){

        // ВВЕСТИ ДЛИННЫЙ НОМЕР (МЕНЬШЕ 10 ЦИФР)

        // вводим номер телефона < 10 цифр
        $("[id=userNumber]").setValue("777000555");

        // CLICK SUBMIT BUTTON

        SelenideElement button = $("#submit");

        // прокруить страницу пока не будет видна кнопка
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );

        // кликнуть на кнопку Submit
        executeJavaScript("arguments[0].click();", button);

        // проверить класс валидации отображается
        boolean displayed = $(byClassName("was-validated")).isDisplayed();
        Assertions.assertTrue(displayed);

        // проверить что поля формы красные
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

}
