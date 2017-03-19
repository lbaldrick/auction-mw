package com.baldrick.auction.dao;

import com.baldrick.auction.model.ItemAuctionDetails;
import java.util.List;

public interface ItemAuctionDao {
    
    public void createItem(ItemAuctionDetails item);
    
    public void deleteItem(String id);
    
    public ItemAuctionDetails getAuctionItem(String id);
    
    public List<ItemAuctionDetails> getAuctionItems(List<String> ids);
}
