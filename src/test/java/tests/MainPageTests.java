package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Проверить раздел Документы ВСК")
    @Story("Пользователь должен успешно перейти в раздел документы")
    public void checkDocumentsVSKPage() {
        open("");
        $("a[href='/about/']").click();
        $(byText("Документы")).click();
        $("h1").should(text("Документы ВСК"));
    }

    @Test
    @DisplayName("Проверить раздел 'Страхование авиационных рисков' ")
    @Story("Пользователь должен успешно перейти в раздел Авиационные риски")
    public void checkAviationRisksPage() {
        open("");
        $("a[href='/companies/']").click();
        $(byText("Авиационные риски")).click();
        $("h1").should(text("Страхование авиационных рисков"));
    }

    @Test
    @DisplayName("Проверить раздел 'Страховой случай-Авто'")
    @Story("Пользователь должен успешно перейти в События -> Раздел ОСАГО")
    public void checkEventPage(){
        open("event/");
        $(byText("Авто")).click();
        $(byText("ОСАГО")).click();
        $("h2").should(text("Сразу после аварии"));

    }
}