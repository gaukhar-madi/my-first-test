package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.components.CalendarComponent;
import pages.components.TableComponent;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();
    // Элементы формы
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUpload =$("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateElement = $("#state"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            validationIndicator = $(byClassName("was-validated"));


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeAdBanners() {
        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String year, String month, String day) {
        dateOfBirthInput.click();
        calendar.setDate(year, month, day);

        return this;
    }

    public RegistrationPage setSubject (String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        pictureUpload.uploadFromClasspath("images/" + value);
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState (String value) {
        stateElement.scrollTo().click(ClickOptions.usingJavaScript());
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity (String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", submitButton);
        return this;
    }

    public void checkValidation(){
        boolean displayed = validationIndicator.isDisplayed();
        Assertions.assertTrue(displayed);
    }

    public RegistrationPage checkResultModalAppears() {
        tableComponent.checkRegistrationResult();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkFinalTable(key, value);
        return this;
    }
}