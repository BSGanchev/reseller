package com.resellerapp.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDTO {
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 20)
    private String username;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
