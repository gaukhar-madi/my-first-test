package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Открыть страницу Text Box")
    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    @Step("Убрать рекламные баннеры")
    public TextBoxPage removeAdBanners() {
        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);
        return this;
    }

    @Step("Ввести полное имя: {value}")
    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email: {value}")
    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Ввести текущий адрес: {value}")
    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Ввести постоянный адрес: {value}")
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    @Step("Нажать кнопку Submit")
    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверить результат вывода формы")
    public TextBoxPage checkResult(String name, String email, String currentAddress, String permanentAddress) {
        outputResult.shouldBe(visible);
        outputResult.$("#name").shouldHave(text(name));
        outputResult.$("#email").shouldHave(text(email));
        outputResult.$("#currentAddress").shouldHave(text(currentAddress));
        outputResult.$("#permanentAddress").shouldHave(text(permanentAddress));
        return this;
    }
}
