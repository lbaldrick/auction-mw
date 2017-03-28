package com.baldrick.auction.store;

import com.baldrick.auction.model.ItemAuctionDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchStoreIndex extends StoreIndex {
  
  private final ArrayList EXCLUDED_WORDS = new ArrayList(Arrays.asList(
    "the",
    "a",
    "there",
    "their",
    "by"));
 
  public void createIndex(List<ItemAuctionDetails> details) {
    details.forEach((d) -> this.addToIndex(d.getItemDetails().getDisplayName(), d));
  }
  
  public void addToIndex(String key, ItemAuctionDetails details) {
    Arrays.stream(key.split("\\s+"))
            .filter((word) -> !EXCLUDED_WORDS.contains(word.toLowerCase()))
            .forEach((word) -> this.add(word, details.getId()));
  }
}
