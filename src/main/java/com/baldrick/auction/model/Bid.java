package com.baldrick.auction.model;

public class Bid {

  private Long timestamp;
  private String userId;
  private double bid;
  
  public Bid() {};

  public Bid(String userId, Long timestamp, double bid) {
    this.timestamp = timestamp;
    this.userId = userId;
    this.bid = bid;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public double getBid() {
    return bid;
  }

  public void setBid(double bid) {
    this.bid = bid;
  }
}
