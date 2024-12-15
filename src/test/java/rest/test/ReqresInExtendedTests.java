package rest.test;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import rest.helpers.CustomApiListener;
import rest.model.LoginRequestModel;
import rest.model.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ReqresInExtendedTests {

    @Test
    void loginTest() {
        LoginRequestModel data = new LoginRequestModel("eve.holt@reqres.in", "cityslicka");
        LoginResponseModel response = given()
                .log().uri()
                .log().headers()
                .log().body()
                .filter(CustomApiListener.withCustomTemplates())
                .contentType(ContentType.JSON)
                .body(data)
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
}
