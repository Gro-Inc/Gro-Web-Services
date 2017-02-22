package com.gro.controller;

import com.gro.DTO.RESTResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {
    @ResponseBody
    @RequestMapping(value = "/send-message", method = RequestMethod.POST)
    public RESTResponse<String> sendMessage(@RequestParam final String message) {
        final RESTResponse<String> sentMessage = new RESTResponse<>();

        sentMessage.setData(message);

        return sentMessage;
    }
}