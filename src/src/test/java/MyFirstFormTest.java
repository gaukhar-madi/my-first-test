import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;


import com.codeborne.selenide.Configuration;

import java.io.File;

public class MyFirstFormTest {

    @Test
    void fillFormTest(){

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        open("https://demoqa.com/automation-practice-form");

        //CONTACT INFORMATION

        // вводим Имя
        $("[id=firstName]").setValue("Michael");
        // вводим Фамилию
        $("[id=lastName]").setValue("Thomas");
        // вводим email
        $("[id=userEmail]").setValue("michaelthomas@mail.ru");
        // выбираем Пол
        $("[id=gender-radio-1]").click();
        // вводим номер телефона
        $("[id=userNumber]").setValue("7770005555");

        //DATE OF BIRTH

        //  кликнуть на строку в датой рождения
        $("[id=dateOfBirthInput]").click();
        // выбрать на календаре в скролле 2001 год
        $(byClassName("react-datepicker__year-select")).selectOption("2001");
        // выбрать из списка месяц Июнь
        $(byClassName("react-datepicker__month-select")).selectOption("June");
        // кликнуть на календаре 1-ое число
        $(byClassName("react-datepicker__day--001")).click();

        //HOBBIES AND PICTURE

        //Выбрать хобби Музыка
        $("[id=hobbies-checkbox-3]").click();
        File picture = new File("/Users/gaukharmadikenova/Downloads/hailey-baldwin-levis-jeans-296776-1638490641328-image.jpg");
        // загрузить файл из компьютера
        $("[id=uploadPicture]").uploadFile(picture);

        //ADDRESS

        // заполниьб поле адреса
        $("[id=currentAddress]").setValue("Baker Street 9");

        //SELECT STATE

        // Метод cssSelector scrollIntoView не работает, не может проскролить до низа
        //$(byClassName("css-1xc3v61-indicatorContainer")).scrollIntoView(true).click();

        // возможные причины что на странице есть сркытые frame-ы или из-за рекламы всплывающей, поэтому использовала JavaScript click

        SelenideElement state = $(byClassName("css-19bb58m"));

        // прокуртить страницу до блок со штатром
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                state
        );

        // кликнуть на штат
        executeJavaScript("arguments[0].click();", state);
        // выбрать из списка штат
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();

        // SELECT CITY
        SelenideElement city = $(byClassName("css-13cymwt-control"));

        // прокуртить страницу до блок с городом
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                city
        );
        // выбрать из списка город
        executeJavaScript("arguments[0].click();", city);
        $("#react-select-4-input").setValue("Jaipur").pressEnter();

        // CLICK SUBMIT BUTTON

        SelenideElement button = $("#submit");

        // прокруить страницу пока не будет видна кнопка
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );

        // кликнуть на кнопку Submit
        executeJavaScript("arguments[0].click();", button);

        // Увидела модальное окно Thank you
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // Выводим что тест пройден успешно
        System.out.println("Форма успешно заполнена. Тест пройден");
    }
}
