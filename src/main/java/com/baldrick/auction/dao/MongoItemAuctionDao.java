package com.baldrick.auction.dao;

import com.baldrick.auction.model.ItemAuctionDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.rx.client.FindObservable;
import com.mongodb.rx.client.MongoClient;
import com.mongodb.rx.client.MongoCollection;
import com.mongodb.rx.client.MongoDatabase;
import com.mongodb.rx.client.Success;
import com.mongodb.rx.client.MongoClients;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

public class MongoItemAuctionDao implements ItemAuctionDao {

  private final Logger slf4jLogger = LoggerFactory.getLogger(MongoItemAuctionDao.class);
  private final String databaseName;
  private final String collectionName;
  private MongoClient mongoClient;
  private MongoCollection<Document> collection;

  public MongoItemAuctionDao(String databaseName, String collectionName) {
    this.databaseName = databaseName;
    this.collectionName = collectionName;
    this.mongoClient = MongoClients.create("mongodb://localhost");
  }

  public void closeConnection() {
    if (this.mongoClient != null) {
      this.mongoClient.close();
      this.mongoClient = null;
      this.collection = null;
    }
  }

  private MongoCollection<Document> getCollection() {
    MongoDatabase db = mongoClient.getDatabase(this.databaseName);
    if (this.collection == null) {
      this.collection = db.getCollection(this.collectionName);
    }

    return this.collection;
  }

  @Override
  public Optional<Observable<Success>> createItem(ItemAuctionDetails item) {
    MongoCollection<Document> col = getCollection();
    ObjectMapper mapper = new ObjectMapper();
    Observable<Success> observer = null;
    try {
      Document document = Document.parse(mapper.writeValueAsString(item));
      observer = col.insertOne(document);
    } catch (JsonProcessingException ex) {
      slf4jLogger.error("Failed to parse item to document for insertion into collection", ex);
    }

    return Optional.ofNullable(observer);
  }

  @Override
  public Observable<DeleteResult> deleteItem(String id) {
    MongoCollection<Document> col = getCollection();
    return col.deleteOne(eq("id", id));
  }

  @Override
  public Observable<Document> getAuctionItem(String id) {
    MongoCollection<Document> col = getCollection();
    return col.find(eq("id", id)).first();
  }

  @Override
  public FindObservable<Document> getAuctionItems(List<String> ids) {
    MongoCollection<Document> col = getCollection();
    return col.find(in("id", ids));
  }

  @Override
  public FindObservable<Document> getAllAuctionItems() {
    MongoCollection<Document> col = getCollection();
    return col.find();
  }
}
