package com.baldrick.auction.dto;

import com.baldrick.auction.model.ItemAuctionDetails;
import java.util.List;

public class ItemsSearchResponse {

  private List<ItemAuctionDetails> items;

  public ItemsSearchResponse(List<ItemAuctionDetails> items) {
    this.items = items;
  }

  public List<ItemAuctionDetails> getItems() {
    return items;
  }

  public void setItems(List<ItemAuctionDetails> items) {
    this.items = items;
  }
}
