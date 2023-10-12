package com.resellerapp.controller;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegistrationDTO;
import com.resellerapp.service.impl.AuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @GetMapping("/users/login")
    public ModelAndView loginUser(){
        return new ModelAndView("login");
    }
    @PostMapping("/users/login")
    public ModelAndView loginUser(UserLoginDTO userLoginDTO) {

        boolean successfulLogin = authService.loginUser(userLoginDTO);

        String view = successfulLogin ? "redirect:/home" : "/login";

        return new ModelAndView(view);
    }
    @GetMapping("/users/register")
    public ModelAndView registerUser() {
        return new ModelAndView("register");
    }
    @PostMapping("/users/register")
    public ModelAndView registerUser(UserRegistrationDTO userRegistrationDTO){

        authService.registerUser(userRegistrationDTO);

        return new ModelAndView("login");
    }
    @PostMapping("/users/logout")
    private ModelAndView logoutUser() {
        authService.logoutUser();
        return new ModelAndView("redirect:/index");
    }
}
