package com.baldrick.auction.store;

import com.baldrick.auction.model.ItemAuctionDetails;
import com.baldrick.auction.service.ItemRetriever;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ItemsStore {
  
  private final ItemRetriever retriever;
          
  private final SearchStoreIndex index;
  
  private Map<String, ItemAuctionDetails> items;
  
  public ItemsStore(ItemRetriever retriever, SearchStoreIndex index) {
    this.retriever = retriever;
    this.index = index;
  }
  
  public void createStore() {
    items = this.retriever.retrieveItems();
  }
  
  public List<ItemAuctionDetails> search(String query) {
    ArrayList<String> queries = new ArrayList(Arrays.asList(query.split("\\s+")));
    HashSet<String> ids = this.getIds(queries);
    List<ItemAuctionDetails> results = new ArrayList<>();
    
    ids.forEach((id) -> {
      ItemAuctionDetails item = items.get(id);
      
      if (item != null) {
        results.add(item);
      }
    });
    
    return results;
  }
  
  private HashSet<String> getIds(ArrayList<String> queries) {
    HashSet<String> ids = new HashSet<>();
    queries.forEach((q) -> {
      Optional<ArrayList<String>> result = index.get(q);
      result.ifPresent(x -> ids.addAll(x));
    });
    return ids;
  }
  
}
