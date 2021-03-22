package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTests extends TestBase {

    @DisplayName("Проверить раздел Документы ВСК")
    @Test
    public void checkDocumentsVSKPage() {
        open("");
        $("a[href='/about/']").click();
        $(byText("Документы")).click();
        $("h1").should(text("Документы ВСК"));
    }

    @DisplayName("Проверить раздел 'Страхование авиационных рисков' ")
    @Test
    public void checkAviationRisksPage() {
        open("");
        $("a[href='/companies/']").click();
        $(byText("Авиационные риски")).click();
        $("h1").should(text("Страхование авиационных рисков"));
    }

    @DisplayName("Проверить раздел 'Страховой случай-Авто'")
    @Test
    public void checkEventPage(){
        open("event/");
        $(byText("Авто")).click();
        $(byText("ОСАГО")).click();
        $("h2").should(text("Сразу после аварии"));

    }
}