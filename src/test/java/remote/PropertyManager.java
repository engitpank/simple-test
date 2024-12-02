package remote;

public class PropertyManager {
    public static final String SELENOID_URL = System.getProperty("SelenoidUrl", "http://localhost:8081");
    public static final String BASE_URL = System.getProperty("baseUrl", "https://demoqa.com");
    public static final String BROWSER_NAME = System.getProperty("Browser", "chrome");
    public static final String BROWSER_VERSION = System.getProperty("BrowserVersion", "128.0");
    public static final String BROWSER_EXC = "1920x1080";
}