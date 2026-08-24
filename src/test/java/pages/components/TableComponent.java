package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TableComponent {
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");
    private final SelenideElement tableResult = $(".table-responsive");

    @Step("Проверить, что модальное окно с результатом появилось")
    public TableComponent checkRegistrationResult() {
        $(".modal-dialog").should(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("Проверить строку таблицы результата: {key} = {value}")
    public TableComponent checkFinalTable(String key, String value) {
        tableResult.$(byText(key))
                .parent()
                .shouldHave(text(value));

        return this;
    }
}
