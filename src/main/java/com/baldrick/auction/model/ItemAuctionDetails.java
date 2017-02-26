package com.baldrick.auction.model;

public class ItemAuctionDetails {
    
    private final ItemDetails itemDetails;
    private final double currentBid;
    private final long expiryTimestamp;
    private final double buyNowPrice;

    public ItemAuctionDetails(ItemDetails itemDetails, double currentBid, long expiryTimestamp, double buyNowPrice) {
        this.itemDetails = itemDetails;
        this.currentBid = currentBid;
        this.expiryTimestamp = expiryTimestamp;
        this.buyNowPrice = buyNowPrice;
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
}
