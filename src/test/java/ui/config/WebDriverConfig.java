package ui.config;


import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:testing.properties"
)
public interface WebDriverConfig extends Config {
    @Key("webdriver.selenoidUrl")
    @DefaultValue("http://localhost:8081")
    String getSelenoidUrl();

    @Key("service.ui.baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("webdriver.browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("webdriver.browserVersion")
    @DefaultValue("128.0")
    String getBrowserVersion();

    @Key("webdriver.browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("webdriver.pageLoadStrategy")
    @DefaultValue("normal")
    String getPageLoadStrategy();

    @Key("webdriver.isEnableVNC")
    @DefaultValue("true")
    Boolean isEnableVNC();

    @Key("webdriver.isEnableVideo")
    @DefaultValue("true")
    Boolean isEnableVideo();
}