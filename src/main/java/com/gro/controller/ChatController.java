package com.gro.controller;

import com.gro.DTO.RESTResponse;
import com.mongodb.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {
    private MongoClient mongoClient;
    private DB db;
    private DBCollection messagesTable;

    @PostConstruct
    public void init() throws UnknownHostException {
        mongoClient = new MongoClient( "localhost" , 27017 );
        db = mongoClient.getDB("gro");
        messagesTable = db.getCollection("messages");
    }

    @ResponseBody
    @RequestMapping(value = "/send-message", method = RequestMethod.POST)
    public RESTResponse<String> sendMessage(@RequestParam final String message) throws UnknownHostException {
        final BasicDBObject document = new BasicDBObject();

        document.put("message", message);

        messagesTable.insert(document);

        final RESTResponse<String> sentMessage = new RESTResponse<>();

        sentMessage.setData(message);

        return sentMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/get-messages", method = RequestMethod.GET)
    public RESTResponse<List<String>> getMessages() {
        final DBCursor cursor = messagesTable.find();
        final RESTResponse<List<String>> restMessages = new RESTResponse<>();
        final List<String> messages = new ArrayList<>(0);

        while (cursor.hasNext()) {
            messages.add((String) cursor.next().get("message"));
        }

        restMessages.setData(messages);

        return restMessages;
    }
}