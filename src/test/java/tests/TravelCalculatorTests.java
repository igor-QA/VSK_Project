package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class TravelCalculatorTests extends TestBase {

    @Test
    @DisplayName("Проверить успешность расчета страхового полиса для путешествий")
    @Story("Пользователь должен успешно получить итоговую сумму по выбранным параметрам")
    public void checkTravelCalculator(){
    step("Открыть страницу 'Тревел Калькулятор'", () ->
        open("https://shop.vsk.ru/calculator/travel/"));

    step("Выбрать параметры для расчета страховки",() ->{
        $(byText("Все страны Шенгена")).click();
        sleep(1000);
        executeJavaScript("window.scrollBy(0,600)"); //TODO Другими путями не скролиться, только js;
        $(byText("Несколько поездок в год")).click();
        $(byText("60")).click();
        $(byText("Багаж")).scrollIntoView(true).click(); }); //TODO Тест может падать из-за долгой загрузки на сайте;

    step("Проверить усешность расчета страхового полиса", ()->
        $("p.sidebar-travel__price").shouldBe(visible)); //TODO value = 6 191 ₽
    }
}