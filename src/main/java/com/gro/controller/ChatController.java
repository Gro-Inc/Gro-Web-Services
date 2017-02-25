package com.gro.controller;

import com.gro.model.DTO.RESTResponse;
import com.gro.model.constants.Table;
import com.gro.model.database.GroDBInterface;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private GroDBInterface groDBInterface;

    @ResponseBody
    @RequestMapping(value = "/send-message", method = RequestMethod.POST)
    public RESTResponse<String> sendMessage(@RequestParam final String message) throws UnknownHostException {
        final BasicDBObject messageDoc = new BasicDBObject();

        messageDoc.put("message", message);

        groDBInterface.getTable(Table.MESSAGES).insert(messageDoc);

        final RESTResponse<String> sentMessage = new RESTResponse<>();

        sentMessage.setData(message);

        return sentMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/get-messages", method = RequestMethod.GET)
    public RESTResponse<List<String>> getMessages() {
        final DBCursor cursor = groDBInterface.getTable(Table.MESSAGES).find();
        final List<String> messages = new ArrayList<>(0);

        while (cursor.hasNext()) {
            messages.add((String) cursor.next().get("message"));
        }

        final RESTResponse<List<String>> restMessages = new RESTResponse<>();

        restMessages.setData(messages);

        return restMessages;
    }
}