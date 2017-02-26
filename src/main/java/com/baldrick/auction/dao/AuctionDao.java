package com.baldrick.auction.dao;

import com.baldrick.auction.model.ItemAuctionDetails;
import java.util.List;

public interface AuctionDao {
    
    public void createItem(String id, String displayName, double currentBid, long expiryTimestamp, double buyNowPrice);
    
    public void deleteItem(String id);
    
    public ItemAuctionDetails getAuctionItem(String id);
    
    public List<ItemAuctionDetails> getAuctionItems(List<String> ids);
}
