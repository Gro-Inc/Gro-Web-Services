package com.gro.controller;

import com.gro.model.DTO.RESTResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @ResponseBody
    @RequestMapping("/")
    public RESTResponse<String> index() {
        final RESTResponse<String> restResponse = new RESTResponse<>();

        restResponse.setData("This is the response from the web service");

        return restResponse;
    }
}