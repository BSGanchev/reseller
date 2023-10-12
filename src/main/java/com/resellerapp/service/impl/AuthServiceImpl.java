package com.resellerapp.service.impl;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegistrationDTO;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.AuthService;
import com.resellerapp.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            CurrentUser currentUser) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }
    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        var user = userRepository.findUserByUsername(userLoginDTO.getUsername()).orElse(null);

        boolean loginSuccess = false;

        if (user != null) {

            String rawPassword = userLoginDTO.getPassword();
            String encodedPassword = user.getPassword();

            loginSuccess = encodedPassword != null & passwordEncoder.matches(rawPassword, encodedPassword);

            if (loginSuccess) {
                currentUser.setLogged(true);
                currentUser.setUsername(user.getUsername());
                currentUser.setId(user.getId());
            } else {
                currentUser.logout();
            }
        }
        return loginSuccess;
    }
    @Override
    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));

        return true;
    }
    @Override
    public void logoutUser() {
        if (currentUser.isLogged()) {
            currentUser.logout();
        }
    }

    private User map(UserRegistrationDTO userRegistrationDTO) {

        User user = new User();

        user.setUsername(userRegistrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setEmail(userRegistrationDTO.getEmail());

        return user;
    }
}
