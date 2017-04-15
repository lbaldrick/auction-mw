package com.baldrick.auction.controller;

import com.baldrick.auction.dto.ItemCreateRequest;
import com.baldrick.auction.dto.ItemsSearchResponse;
import com.baldrick.auction.store.ItemsStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemsController {

  @Autowired
  private final ItemsStore itemsStore;

  public ItemsController(ItemsStore itemsStore) {
    this.itemsStore = itemsStore;
  }

  @RequestMapping(value = "/{query}", method = RequestMethod.GET)
  public ItemsSearchResponse search(@PathVariable String query) {
    return new ItemsSearchResponse(this.itemsStore.search(query));
  }

  @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
  public String getItem(@PathVariable String query) {
    return query;
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public void createItem(@RequestBody ItemCreateRequest item) {
    System.out.println("create " + item.toString());
  }

}
