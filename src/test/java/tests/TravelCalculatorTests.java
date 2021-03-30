package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("web")
public class TravelCalculatorTests extends TestBase {

    @Test
    @DisplayName("Проверить успешность расчета страхового полиса для путешествий")
    @Story("Пользователь должен успешно получить итоговую сумму по выбранным параметрам")
    public void checkTravelCalculator() {
        step("Открыть страницу 'Тревел Калькулятор'", () ->
                travelCalculatorPage.openPage());

        step("Выбрать параметры для расчета страховки", () ->
                travelCalculatorPage.selectOptions());

        step("Проверить усешность расчета страхового полиса", () ->
                travelCalculatorPage.checkCorrectPrice());
    }
}