import org.junit.jupiter.api.Test;
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

        $("[id=firstName]").setValue("Michael");
        $("[id=lastName]").setValue("Thomas");
        $("[id=userEmail]").setValue("michaelthomas@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("+77770005555");

        //DATE OF BIRTH

        $("[id=dateOfBirthInput]").click();
        $(byClassName("react-datepicker__year-select")).selectOption("2001");
        $(byClassName("react-datepicker__month-select")).selectOption("June");
        $(byClassName("react-datepicker__day--001")).click();

        //HOBBIES AND PICTURE

        $("[id=hobbies-checkbox-3]").click();
        File picture = new File("/Users/gaukharmadikenova/Downloads/hailey-baldwin-levis-jeans-296776-1638490641328-image.jpg");
        $("[id=uploadPicture]").uploadFile(picture);

        //ADDRESS
        $("[id=currentAddress]").setValue("Baker Street 9");

        //CITY AND STATE

        $(byClassName("css-1xc3v61-indicatorContainer")).scrollIntoView(true).click();

        $("#react-select-3-input").setValue("Rajasthan").pressEnter();

        $(byClassName("css-1xc3v61-indicatorContainer")).click();

        $("#react-select-4-input").setValue("Jaipur").pressEnter();

        $("#submit").click();

    }
}
