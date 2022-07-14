package com.geo.semiproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class pageController {
    @RequestMapping(value = "",  method = RequestMethod.GET)
    public String start() {
        return "index.html";
    }
}
