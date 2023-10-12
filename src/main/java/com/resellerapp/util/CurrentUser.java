package com.resellerapp.util;

import com.resellerapp.model.entity.BaseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser extends BaseEntity {

    private String username;
    private boolean isLogged;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
    public void logout() {
        setLogged(false);
        setUsername(null);
        setId(null);
    }
}
