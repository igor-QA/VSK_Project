package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Проверить раздел Документы ВСК")
    @Story("Пользователь должен успешно перейти в раздел документы")
    public void checkDocumentsVSKPage() {
    step("Открыть главную страницу сайта", () ->
        open(""));

    step("Перейти в раздел 'О Клмпании'", () -> {
        $("a[href='/about/']").click();
        $(byText("Документы")).click(); });

    step("Проверить успешность выполнения сценария", () ->
        $("h1").should(text("Документы ВСК")));
    }

    @Test
    @DisplayName("Проверить раздел 'Страхование авиационных рисков' ")
    @Story("Пользователь должен успешно перейти в раздел Авиационные риски")
    public void checkAviationRisksPage() {
    step("Открыть главную страницу сайта", () ->
                open(""));

    step("Перейти в раздел Бизнесу -> Авиационные риски", () -> {
        $("a[href='/companies/']").click();
        $(byText("Авиационные риски")).click(); });

    step("Проверить успешность выполнения сценария", () ->
        $("h1").should(text("Страхование авиационных рисков")));
    }

    @Test
    @DisplayName("Проверить раздел 'Страховой случай-Авто'")
    @Story("Пользователь должен успешно перейти в События -> Раздел ОСАГО")
    public void checkEventPage(){
    step("Открыть страницу Страховые события", ()->
        open("event/"));

    step("Выбрать раздел 'Авто и перейти в пункт ОСАГО'", () -> {
        $(byText("Авто")).click();
        $(byText("ОСАГО")).click(); });

    step("Проверить успешность выполнения сценария", ()->
        $("h2").should(text("Сразу после аварии")));
    }
}