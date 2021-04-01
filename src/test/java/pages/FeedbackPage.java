package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FeedbackPage {
    private final SelenideElement question = $(byText("вопрос")),
            noPolicy = $(byText("нет")),
            buyPolicy = $(byText("покупка полиса"));

    @Step("Выбрать цель обращения")
    public FeedbackPage selectQuestion() {
        question.click();
        return this;
    }

    @Step("Выбрать наличие действующего полиса (да/нет)")
    public FeedbackPage selectParameters() {
        noPolicy.click();
        return this;
    }

    @Step("Выбрать повод для обращения")
    public void selectAppeal() {
        buyPolicy.click();
    }

    @Step("Выбрать адрес из выпадающего списка")
    public FeedbackPage selectAddress() {
        $x("//li[contains(text(),'Амурская область')]").click();
        return this;
    }

    @Step("Ввести ФИО: {fullName}")
    public FeedbackPage inputFullName(String fullName) {
        $("#FeedbackForm_name").val(fullName).click();
        return this;
    }

    @Step("Ввести Число, Месяц, Год рождения(чч.ММ.гггг): {dayOfBirth}")
    public FeedbackPage inputDateOfBirthday(String dayOfBirth) {
        $("#FeedbackForm_date").val(dayOfBirth).pressEnter();
        return this;
    }

    @Step("Ввести номер контактного телефона: {phoneNumber}")
    public FeedbackPage inputPhone(String phoneNumber) {
        $("#FeedbackForm_phone").scrollIntoView(true).val(phoneNumber).click();
        return this;
    }

    @Step("Ввести электронную почту: {userEmail}")
    public FeedbackPage inputEmail(String userEmail) {
        $("#FeedbackForm_email").val(userEmail).click();
        return this;
    }

    @Step("Нажать отправить")
    public void clickSubmitBtn() {
        $(".b-checkbox__checker").click();
        $(byValue("Отправить")).scrollIntoView(true).click();
    }

    @Step("Проверить успешность отправки формы")
    public void checkResult() {
        $(".js-success-message b-feedback-page__success").should(appear);
    }
}
