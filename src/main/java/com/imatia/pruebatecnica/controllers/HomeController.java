package com.imatia.pruebatecnica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public ModelAndView Index() {
        return new ModelAndView("redirect:" + "./swagger-ui.html");
    }
}
