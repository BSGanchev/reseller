package com.resellerapp.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {
    @GetMapping("/offers")
    public ModelAndView offerAdd(){
        return new ModelAndView("offer-add");
    }
}
