package com.baldrick.auction.model;

public class ItemDetails {

  private String displayName;
  private String description;
  private String summary;
  private ItemSpecifics itemSpecifics;

  public ItemDetails() {};
  
  public ItemDetails(String displayName, String description, String summary, ItemSpecifics itemSpecifics) {
    this.displayName = displayName;
    this.description = description;
    this.summary = summary;
    this.itemSpecifics = itemSpecifics;
  }

  public String getDescription() {
    return description;
  }

  public String getSummary() {
    return summary;
  }

  public String getDisplayName() {
    return displayName;
  }

  public ItemSpecifics getItemSpecifics() {
    return itemSpecifics;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public void setItemSpecifics(ItemSpecifics itemSpecifics) {
    this.itemSpecifics = itemSpecifics;
  } 
}
