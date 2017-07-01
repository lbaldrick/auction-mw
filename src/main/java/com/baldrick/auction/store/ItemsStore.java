package com.baldrick.auction.store;

import com.baldrick.auction.model.ItemAuctionDetails;
import com.baldrick.auction.service.ItemResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class ItemsStore {
          
  private final SearchStoreIndex index;
  
  private final ItemResolver itemResolver;
  
  private ConcurrentHashMap<String, ItemAuctionDetails> items;
  
  public ItemsStore(ItemResolver itemResolver, SearchStoreIndex index) {
    this.index = index;
    this.itemResolver = itemResolver;
    this.createStore(index, itemResolver);
  }
  
  public void createStore(SearchStoreIndex index, ItemResolver itemResolver) {
    this.items = itemResolver.retrieveItems();
    index.createIndex(items.values());
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
  
  public void addItemToStore(ItemAuctionDetails details) {
    this.items.put(details.getId(), details);
    this.index.addToIndex(details.getItemDetails().getDisplayName(), details);
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
