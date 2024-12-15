package rest.model;

public class LoginResponseModel {
    private final String token;

    public LoginResponseModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
