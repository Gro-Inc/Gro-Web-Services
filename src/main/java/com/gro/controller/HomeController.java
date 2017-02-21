package com.gro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @ResponseBody
    @RequestMapping(value = "/", produces = "text/html")
    public String index() {
        return "This is a response from the web service";
    }
}