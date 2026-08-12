package pages.components;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TableComponent {
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");
    private final SelenideElement tableResult = $(".table-responsive");

    public TableComponent checkRegistrationResult() {
        $(".modal-dialog").should(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public TableComponent checkFinalTable(String key, String value) {
        tableResult.$(byText(key))
                .parent()
                .shouldHave(text(value));

        return this;
    }
}
