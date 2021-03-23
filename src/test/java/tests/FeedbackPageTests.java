package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class FeedbackPageTests extends TestBase {

    @DisplayName("Проверить раздел 'Обратная связь' ")
    @Story("Пользователь должен успешно отправить вопрос и получить номер обращения")
    @Test
    public void checkFeedbackPage() {
    step("Открыть страницу с формой обртаной связи", () ->
        open("feedback/"));

    step("Заполнить форму и нажать отправить", () -> {
        $(byText("вопрос")).click();
        $(byText("нет")).click();
        $(byText("покупка полиса")).click();
        $x("//li[contains(text(),'Амурская область')]").click();
        $("#FeedbackForm_name").val("Тестов Тест Тестович").click();
        $("#FeedbackForm_date").val("13.11.1986").pressEnter();
        $("#FeedbackForm_phone").val("79999999999").click();
        $("#FeedbackForm_email").val("test@test.ru").click();
        $(".b-checkbox__checker").click(); });
        $(byValue("Отправить")).click();

    step("Проверить успешность отправки формы", () ->
        $(".js-success-message b-feedback-page__success").should(appear)); //TODO Страница открывается в нижний ее части и номер заявки не попадает в поле видимости

    }
}