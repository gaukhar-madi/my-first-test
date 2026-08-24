package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    @Step("Выбрать в календаре дату: {day} {month} {year}")
    public void setDate(String year, String month, String day) {

        $("#dateOfBirthInput").click();
        $(byClassName("react-datepicker__year-select")).selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        String formattedDay = String.format("%03d", Integer.parseInt(day));
        $(".react-datepicker__day--" + formattedDay + ":not(.react-datepicker__day--outside-month)").click();
    }
}
