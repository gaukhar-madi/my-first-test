import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class MyFirstFormTest extends TestBase{

    @Test
    void fillFormTest(){

     // Заполнение полей
        $("[id=firstName]").setValue("Michael");
        $("[id=lastName]").setValue("Thomas");
        $("[id=userEmail]").setValue("michaelthomas@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("7770005555");

        $("[id=dateOfBirthInput]").click();
        $(byClassName("react-datepicker__year-select")).selectOption("2001");
        $(byClassName("react-datepicker__day--001")).click();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("images/hailey-baldwin.jpg");

        $("[id=currentAddress]").setValue("Baker Street 9");

        $(byClassName("css-1xc3v61-indicatorContainer")).scrollIntoView(true).click();
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();

        $("#react-select-4-input").setValue("Jaipur").pressEnter();

        SelenideElement button = $("#submit");
        button.click();

        // Check for Thank you message
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // Print that test is successful
        System.out.println("Форма успешно заполнена. Тест пройден");
    }
}
