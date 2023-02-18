package com.vupham0402.spring_security_sign_in.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SignInRequest {
    @NotBlank(message = "Please input email")
    private String email;
    @NotBlank(message = "Please input password")
//    @Pattern(
//            regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$",
//            message = "Password needs to follow rule")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
