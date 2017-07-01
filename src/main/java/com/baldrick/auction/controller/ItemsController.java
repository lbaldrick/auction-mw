package com.baldrick.auction.controller;

import com.baldrick.auction.dto.ItemCreateRequest;
import com.baldrick.auction.dto.ItemsSearchResponse;
import com.baldrick.auction.model.ItemAuctionDetails;
import com.baldrick.auction.model.ItemDetails;
import com.baldrick.auction.model.ItemSpecifics;
import com.baldrick.auction.model.User;
import com.baldrick.auction.store.ItemsStore;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/items")
public class ItemsController {

  @Autowired
  private ItemsStore itemsStore;
  
  private int id = 0;

  @RequestMapping(value = "/query={query}", method = RequestMethod.GET)
  public ItemsSearchResponse search(@PathVariable String query) {
    return new ItemsSearchResponse(this.itemsStore.search(query));
  }

  @RequestMapping(value = "/id={id}", method = RequestMethod.GET)
  public String getItem(@PathVariable String query) {
    return query;
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public void createItem(@RequestBody ItemCreateRequest item) {
    System.out.println("create " + item.toString());
    User user = new User(Integer.toString(id++), "baldy", 3.5, new ArrayList<>());
    ItemSpecifics specifics = new ItemSpecifics(item.getCondition(),  
            item.getModel(), new ArrayList<>(), item.getPurchasedDate(), item.getLocation(), item.getSellerNotes());
    ItemDetails itemDetails = new ItemDetails("", item.getDescription(), item.getSummary(), specifics);
    ItemAuctionDetails auctionDetails = new ItemAuctionDetails(Integer.toString(id++), itemDetails, 0.0,  new Date().getTime() + 30000, item.getBuyNow(), new ArrayList<>(), user);
    this.itemsStore.addItemToStore(auctionDetails);
  }

}
