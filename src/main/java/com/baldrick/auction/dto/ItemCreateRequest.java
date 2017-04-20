package com.baldrick.auction.dto;

public class ItemCreateRequest {
  
  private String name;
  private String summary;
  private String description;
  private double buyNow;
  private String condition;
  private String model;
  private String features;
  private String purchasedDate;
  private String location;
  private String sellerNotes;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getBuyNow() {
    return buyNow;
  }

  public void setBuyNow(double buyNow) {
    this.buyNow = buyNow;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getFeatures() {
    return features;
  }

  public void setFeatures(String features) {
    this.features = features;
  }

  public String getPurchasedDate() {
    return purchasedDate;
  }

  public void setPurchasedDate(String purchasedDate) {
    this.purchasedDate = purchasedDate;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getSellerNotes() {
    return sellerNotes;
  }

  public void setSellerNotes(String sellerNotes) {
    this.sellerNotes = sellerNotes;
  }
}
