package com.baldrick.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baldrick.auction.dao.ItemAuctionDao;
import com.baldrick.auction.model.ItemAuctionDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.bson.Document;

@Service
public class ItemRetriever {

  @Autowired
  private final ItemAuctionDao datasource;

  public ItemRetriever(ItemAuctionDao datasource) {
    this.datasource = datasource;
  }

  public Map<String, ItemAuctionDetails> retrieveItems() {
    Map<String, ItemAuctionDetails> items = new HashMap<>();
    datasource.getAllAuctionItems()
            .toObservable()
            .toBlocking()
            .forEach((doc) -> {
              Optional<ItemAuctionDetails> item = this.mapItems(doc);
              item.ifPresent((i) -> items.put(i.getId(), i));
            });
    
    return items;
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
