package com.baldrick.auction.model;

public class ItemDetails {
    
    private final String id;
    private final String displayName;
    
    public ItemDetails(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }
}
