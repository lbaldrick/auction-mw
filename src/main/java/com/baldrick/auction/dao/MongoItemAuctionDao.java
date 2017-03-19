package com.baldrick.auction.dao;

import com.baldrick.auction.model.ItemAuctionDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoItemAuctionDao implements ItemAuctionDao{
    private final Logger slf4jLogger = LoggerFactory.getLogger(MongoItemAuctionDao.class);
    private final String url;
    private final int port;
    private final String databaseName;
    private final String collectionName;
    private MongoClient mongoClient;
    private MongoCollection<Document> collection;
    
    private MongoItemAuctionDao(String url, int port, String databaseName, String collectionName) {
        this.url = url;
        this.port = port;
        this.databaseName = databaseName;
        this.collectionName = collectionName;
    }
    
    public void openConnection() {
        if(this.mongoClient == null) {
            this.mongoClient = new MongoClient(this.url, this.port);
        }
    }
    
    public void closeConnection() {
        if(this.mongoClient != null) {
            this.mongoClient.close();
            this.mongoClient = null;
            this.collection = null;
        }
    }
    
    private MongoCollection<Document> getCollection() {
        MongoDatabase db = mongoClient.getDatabase(this.databaseName);
        if(this.collection == null) {
            this.collection = db.getCollection(this.collectionName);
        }
        
        return this.collection ;
    }

    @Override
    public void createItem(ItemAuctionDetails item) {
        MongoCollection<Document> col = getCollection();
        ObjectMapper mapper = new ObjectMapper();
        Document document;
        try {
            document = Document.parse(mapper.writeValueAsString(item));
            col.insertOne(document);
            slf4jLogger.info("Inserted document into collection {}", this.collectionName);
        } catch (JsonProcessingException ex) {
            slf4jLogger.error("Failed inserting document into collection {}", ex);
        }
    }

    @Override
    public void deleteItem(String id) {
        MongoCollection<Document> col = getCollection();
        col.deleteOne(eq("id", id));
        slf4jLogger.info("Deleted document from collection {}", this.collectionName);
    }

    @Override
    public ItemAuctionDetails getAuctionItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemAuctionDetails> getAuctionItems(List<String> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
