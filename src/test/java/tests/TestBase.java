package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;


public class TestBase {

    private static final WebDriverConfig config =
            ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    public static void beforeAll() {

        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.headless = config.headless();
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";

        if (!config.browserVersion().isBlank()) {
            Configuration.browserVersion = config.browserVersion();
        }

        // Если remoteUrl задан -> запускаемся на удалённом Selenoid, иначе локально
        if (!config.remoteUrl().isBlank()) {
            Configuration.remote = config.remoteUrl();
            Configuration.browserCapabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
        }
    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("allure");
    }
}
