package rest.test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ReqresInTests {
    /*
        1. Make POST request to https://reqres.in/api/login
        with body { "email": "eve.holt@reqres.in", "password": "cityslicka" }
        2. Get response { "token": "QpwL5tke4Pnpja7X4" }
        3. Check response status is 200
     */

    @Test
    void loginTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";
        given()
                .log().uri()
                .contentType("application/json")
                .body(data)
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void inCorrectLoginDataTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in1\", \"password\": \"cityslicka\" }";
        given()
                .log().uri()
                .contentType("application/json")
                .body(data)
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .body("error", is("user not found"))
                .statusCode(400);
    }

    @Test
    void unSupportedMediaTypeLoginTest() {
        given()
                .log().uri()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(415);
    }

    @Test
    void missingEmailOrPasswordLoginTest() {
        given()
                .log().uri()
                .contentType("application/json")
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .body("error", is("Missing email or username"))
                .statusCode(400);
    }

    @Test
    void missingPasswordLoginTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in1\" }";
        given()
                .log().uri()
                .contentType("application/json")
                .body(data)
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .body("error", is("Missing password"))
                .statusCode(400);
    }

    @Test
    void userNotFoundTest() {
        given()
                .log().uri()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().status()
                .statusCode(404);
    }

    @Test
    void userFoundTest() {
        given()
                .log().uri()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.email", is("janet.weaver@reqres.in"));
    }

    @Test
    void createUserTest() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        given()
                .log().uri()
                .log().body()
                .body(data)
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201);
    }

    @Test
    void unSupportedMediaTypeCreateUserTest() {

        given()
                .log().uri()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(415);
    }

    @Test
    void patchUserTest() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        given()
                .log().uri()
                .log().body()
                .body(data)
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void putUserTest() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        given()
                .log().uri()
                .log().body()
                .body(data)
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void deleteUserTest() {
        given()
                .log().uri()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
}
