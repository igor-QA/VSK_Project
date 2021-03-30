package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.FeedbackPage;
import pages.TravelCalculatorPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {
    TravelCalculatorPage travelCalculatorPage = new TravelCalculatorPage();
    FeedbackPage feedbackPage = new FeedbackPage();

    public final String fullName = "Тестов Тест Тестович";
    public final String dayOfBirth = "13.11.1986";
    public final String phoneNumber = "79999999999";
    public final String userEmail = "test@test.ru";

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.baseUrl = "https://www.vsk.ru/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.fileDownload = FOLDER;
        //Configuration.remote = ConfigHelper.getURL();
        Configuration.browser = "firefox";
        //Configuration.browserSize = "1900x1200";

        Map<String, Object> prefs = new HashMap<>();
        ChromeOptions options = new ChromeOptions();
        prefs.put("profile.default_content_settings.cookies", 2);
        prefs.put("network.cookie.cookieBehavior", 2);
        prefs.put("profile.block_third_party_cookies", true);
        options.setExperimentalOption("prefs", prefs);  /**Выключить Cookies*/
    }

    @AfterEach
    @Step("Attachments")
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        attachVideo();

        closeWebDriver();
    }
}