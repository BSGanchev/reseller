package com.resellerapp.model.dto;

import com.resellerapp.model.entity.BaseEntity;
import com.resellerapp.model.validation.PasswordValidator;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@PasswordValidator(first = "password", second = "confirmPassword", message = "Password must match")
public class UserRegistrationDTO extends BaseEntity {
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 20)
    private String username;
    @Column(unique = true, nullable = false)
    @Email
    private String email;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    private String confirmPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
