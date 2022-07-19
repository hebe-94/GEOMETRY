package com.geo.semiproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class pageController {
    @RequestMapping(value = "",  method = RequestMethod.GET)
    public String start() {
        return "thymeleaf/index";
    }

    @GetMapping("/jsp")
    public String test(){
        return "/index";
    }

    @GetMapping("/picture")
    public String makePicture(){
        return "/makePicture";
    }

    @GetMapping("/polygon")
    public String makePolygon(){
        return "/makePolygon";
    }
}
