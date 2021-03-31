package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TravelCalculatorPage {
    @Step("Открыть страницу 'Тревел Калькулятор' ")
    public void openPage() {
        open("https://shop.vsk.ru/calculator/travel/");
    }

    @Step("Выбрать параметры для расчета страховки")
    public void selectOptions() {
        $(byText("Все страны Шенгена")).click();
        sleep(1000);
        executeJavaScript("window.scrollBy(0,600)"); //TODO Другими путями не скролиться, только js;
        $(byText("Несколько поездок в год")).click();
        $(byText("60")).click();
        //$(byText("Багаж")).scrollIntoView(true).click(); //TODO Тест может падать из-за долгой загрузки на сайте;
    }

    @Step("Проверить усешность расчета страхового полиса")
    public void checkCorrectPrice() {
        $("p.sidebar-travel__price").shouldHave(visible); //TODO value = 6 191 ₽
    }
}