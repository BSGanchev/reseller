package com.resellerapp.service;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegistrationDTO;

public interface AuthService {
    boolean loginUser(UserLoginDTO userLoginDTO);
    boolean registerUser(UserRegistrationDTO userRegistrationDTO);
    void logoutUser();
}
