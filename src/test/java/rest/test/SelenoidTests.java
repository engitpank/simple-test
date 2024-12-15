package rest.test;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ui.config.WebDriverConfig;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class SelenoidTests {

    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


    @Test
    void checkTotalSession() {
        get(config.getSelenoidUrl() + "/status")
                .then().body("state.total", is(5));
    }

    @Test
    void checkTotalSessionWithStatus() {
        System.out.println(config.getSelenoidUrl() + "/status");
        get(config.getSelenoidUrl() + "/status")
                .then()
                .statusCode(200)
                .body("state.total", is(5));
    }

    @Test
    void checkTotalSessionWithGiven() {
        given()
                .when()
                .get(config.getSelenoidUrl() + "/status")
                .then()
                .body("state.total", is(5));
    }

    @Test
    void checkTotalSessionWithLogs() {
        given()
                .log().all()
                .when()
                .get(config.getSelenoidUrl() + "/status")
                .then()
                .log().all()
                .statusCode(200)
                .body("state.total", is(5));
    }

    @Test
    void checkTotalSessionWithSomeLogs() {
        given()
                .log().uri()
                .when()
                .get(config.getSelenoidUrl() + "/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("state.total", is(5));
    }

    @Test
    void checkChromeVersion() {
        given()
                .log().uri()
                .when()
                .get(config.getSelenoidUrl() + "/status")
                .then()
                .log().status()
                .log().body()
                .body("state.browsers.chrome", hasKey(config.getBrowserVersion()));
    }
}
