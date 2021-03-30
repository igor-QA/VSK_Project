package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FeedbackPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class FeedbackPageTests extends TestBase {

    @DisplayName("Проверить раздел 'Обратная связь' ")
    @Story("Пользователь должен успешно отправить вопрос и получить номер обращения")
    @Test
    public void checkFeedbackPage() {
        open("feedback/");
        feedbackPage
                .selectQuestion()
                .selectParameters()
                .selectAppeal();

        feedbackPage
                .selectAddress()
                .inputFullName(fullName)
                .inputDateOfBirthday(dayOfBirth)
                .inputPhone(phoneNumber)
                .inputEmail(userEmail)
                .clickSubmitBtn();

        feedbackPage.checkResult();
//TODO Страница открывается в нижний ее части и номер заявки не попадает в поле видимости
    }
}