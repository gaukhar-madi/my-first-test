package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputResult = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String name, String email, String currentAddress, String permanentAddress) {
        outputResult.shouldBe(visible);
        outputResult.$("#name").shouldHave(text(name));
        outputResult.$("#email").shouldHave(text(email));
        outputResult.$("#currentAddress").shouldHave(text(currentAddress));
        outputResult.$("#permanentAddress").shouldHave(text(permanentAddress));
        return this;
    }
}