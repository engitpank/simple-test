package simple;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
