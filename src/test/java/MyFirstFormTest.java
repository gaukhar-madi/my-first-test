import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class MyFirstFormTest extends TestBase {

    @Test
    void fillFullFormTest() {

        open(fullFormPage);
        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);
        // Заполнение полей
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("[id=userNumber]").setValue(phoneNumber);
        $("#subjectsInput").setValue(subject).pressEnter();

        $("[id=dateOfBirthInput]").click();
        $(byClassName("react-datepicker__year-select")).selectOption(birthYear);
        $(".react-datepicker__month-select").selectOption(birthMonth);
        String formattedDay = String.format("%03d", birthDay);
        $(".react-datepicker__day--" + formattedDay).click();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("images/" + picture);
        $("[id=currentAddress]").setValue(currentAddress);
        $("#state").scrollTo().shouldBe(Condition.visible).click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").scrollIntoView(true);
        executeJavaScript("arguments[0].click();", $("#submit"));

        // Check for Thank you message
        $("#example-modal-sizes-title-lg").shouldHave(text(thankYouMsg));

        //Проверка заполненных полей
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(phoneNumber));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(birthDay + " " + birthMonth + "," + birthYear));
        $(".table-responsive").shouldHave(text(picture));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(state));
        $(".table-responsive").shouldHave(text(city));
    }

    @Test
    void fillShortFormTest(){
        open(shortFormPage);
        // Заполнение полей
        $("#userName").setValue(firstName + " " + lastName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        $("#submit").click();

        // Проверка выведенных результатов
        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text(firstName + " " + lastName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
