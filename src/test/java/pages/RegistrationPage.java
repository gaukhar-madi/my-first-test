package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // Элементы формы
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            yearPicker =  $(byClassName("react-datepicker__year-select")),
            monthPicker = $(".react-datepicker__month-select"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUpload =$("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateElement = $("#state"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            modalResult = $(".modal-content"),
            tableResult = $(".table-responsive");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
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

    public RegistrationPage setDateOfBirth (String birthYear, String birthMonth, int birthDay) {

        dateOfBirthInput.click();
        yearPicker.selectOption(birthYear);
        monthPicker.selectOption(birthMonth);
        String formattedDay = String.format("%03d", birthDay);
        $(".react-datepicker__day--" + formattedDay + ":not(.react-datepicker__day--outside-month)").click();

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

    public RegistrationPage checkResultModalAppears() {
        modalResult.shouldBe(visible);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResult.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}