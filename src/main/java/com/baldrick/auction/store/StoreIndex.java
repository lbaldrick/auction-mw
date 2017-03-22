package com.baldrick.auction.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class StoreIndex {
  
  protected final HashMap<String, ArrayList<String>> index;
  
  public StoreIndex() {
    this.index = new HashMap<>();
  }
  
  public void add(String key, String value) {
    Optional<ArrayList> values = Optional.ofNullable(this.index.get(key));
    
    if (values.isPresent()) {
      values.get().add(value);
    } else {
      this.index.put(key, new ArrayList<>(Arrays.asList(value)));
    }
  }
  
  public Optional<ArrayList<String>> get(String key) {
    return Optional.ofNullable(this.index.get(key));
  }
}
