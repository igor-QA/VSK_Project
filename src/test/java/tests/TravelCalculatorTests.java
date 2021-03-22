package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TravelCalculatorTests extends TestBase {

    @DisplayName("Проверить успешность расчета страхового полиса для путешествий")
    @Story("Пользователь должен успешно получить итоговую сумму по выбранным параметрам")
    @Test
    public void checkTravelCalculator(){
        open("https://shop.vsk.ru/calculator/travel/");
        $(byText("Все страны Шенгена")).click();
        sleep(1000);
        executeJavaScript("window.scrollBy(0,600)"); //TODO Другими путями не скролиться, только js;
        $(byText("Несколько поездок в год")).click();
        $(byText("60")).click();
        $(byText("Багаж")).scrollIntoView(true).click();
        $("p.sidebar-travel__price").shouldBe(visible); //TODO value = 6 191 ₽
    }
}