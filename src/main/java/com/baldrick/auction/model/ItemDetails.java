package com.baldrick.auction.model;

public class ItemDetails {

  private final String displayName;
  private final String description;
  private final String summary;
  private final ItemSpecifics itemSpecifics;

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
}
