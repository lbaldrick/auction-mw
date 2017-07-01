package com.baldrick.auction.service;

import com.baldrick.auction.dao.ItemAuctionDao;
import com.baldrick.auction.model.ItemAuctionDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.bson.Document;

public class ItemResolver {

  private final ItemAuctionDao datasource;

  public ItemResolver(ItemAuctionDao datasource) {
    this.datasource = datasource;
  }

  public ConcurrentHashMap<String, ItemAuctionDetails> retrieveItems() {
    ConcurrentHashMap<String, ItemAuctionDetails> items = new ConcurrentHashMap<>();
    datasource.getAllAuctionItems()
            .toObservable()
            .toBlocking()
            .forEach((doc) -> {
              Optional<ItemAuctionDetails> item = this.mapItems(doc);
              item.ifPresent((i) -> items.put(i.getId(), i));
            });
    
    return items;
  }
  
  public void addItem(String id, ItemAuctionDetails details) {
    datasource.createItem(details).ifPresent(o -> o.subscribe());
  }
  
  private Optional<ItemAuctionDetails> mapItems(Document bson) {
    ObjectMapper mapper = new ObjectMapper();
    ItemAuctionDetails details;
    try {
      details = mapper.readValue(bson.toJson(), ItemAuctionDetails.class);
    } catch (IOException ex) {
      details = null;
    }

    return Optional.of(details);
  }
}
