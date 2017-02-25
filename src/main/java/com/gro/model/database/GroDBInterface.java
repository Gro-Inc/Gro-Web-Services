package com.gro.model.database;

import com.gro.model.constants.Table;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;

@Component
public class GroDBInterface {
    private MongoClient mongoClient;
    private DB db;

    @PostConstruct
    public void init() throws UnknownHostException {
        mongoClient = new MongoClient( "localhost" , 27017 );
        db = mongoClient.getDB("gro");
    }

    public DBCollection getTable(final Table table) {
        return db.getCollection(table.getTableName());
    }
}