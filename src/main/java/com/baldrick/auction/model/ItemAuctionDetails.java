package com.baldrick.auction.model;

import java.util.List;

public class ItemAuctionDetails {

  private String id;
  private ItemDetails itemDetails;
  private double currentBid;
  private long expiryTimestamp;
  private double buyNowPrice;
  private List<Bid> history;
  private User seller;
  
  public ItemAuctionDetails() {};

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

  public void setId(String id) {
    this.id = id;
  }

  public void setItemDetails(ItemDetails itemDetails) {
    this.itemDetails = itemDetails;
  }

  public void setCurrentBid(double currentBid) {
    this.currentBid = currentBid;
  }

  public void setExpiryTimestamp(long expiryTimestamp) {
    this.expiryTimestamp = expiryTimestamp;
  }

  public void setBuyNowPrice(double buyNowPrice) {
    this.buyNowPrice = buyNowPrice;
  }

  public void setHistory(List<Bid> history) {
    this.history = history;
  }

  public void setSeller(User seller) {
    this.seller = seller;
  }
}
