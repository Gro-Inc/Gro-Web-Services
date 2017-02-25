package com.gro.controller;

import com.gro.model.constants.Table;
import com.gro.model.database.GroDBInterface;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GroDBInterface groDBInterface;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser(
            @RequestParam final String username,
            @RequestParam final String password
    ) {
        final BasicDBObject userDoc = new BasicDBObject();

        userDoc.put("username", username);
        userDoc.put("password", password);

        groDBInterface.getTable(Table.USERS).insert(userDoc);
    }
}