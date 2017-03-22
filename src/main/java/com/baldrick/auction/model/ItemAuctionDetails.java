package com.baldrick.auction.model;

import java.util.List;

public class ItemAuctionDetails {

  private final String id;
  private final ItemDetails itemDetails;
  private final double currentBid;
  private final long expiryTimestamp;
  private final double buyNowPrice;
  private final List<Bid> history;
  private final User seller;

  public ItemAuctionDetails(String id, ItemDetails itemDetails, double currentBid, long expiryTimestamp, double buyNowPrice, List<Bid> history, User seller) {
    this.id = id;
    this.itemDetails = itemDetails;
    this.currentBid = currentBid;
    this.expiryTimestamp = expiryTimestamp;
    this.buyNowPrice = buyNowPrice;
    this.history = history;
    this.seller = seller;
  }

  public String getId() {
    return id;
  }

  public ItemDetails getItemDetails() {
    return itemDetails;
  }

  public double getCurrentBid() {
    return currentBid;
  }

  public long getExpiryTimestamp() {
    return expiryTimestamp;
  }

  public double getBuyNowPrice() {
    return buyNowPrice;
  }

  public List<Bid> getHistory() {
    return history;
  }

  public User getSeller() {
    return seller;
  }
}
