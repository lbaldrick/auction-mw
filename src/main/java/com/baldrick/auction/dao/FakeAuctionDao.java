package com.baldrick.auction.dao;

import com.baldrick.auction.model.ItemAuctionDetails;
import com.baldrick.auction.model.ItemDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FakeAuctionDao implements AuctionDao {

    @Override
    public void createItem(String id, String displayName, double currentBid, long expiryTimestamp, double buyNowPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemAuctionDetails getAuctionItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemAuctionDetails> getAuctionItems(List<String> ids) {
        ItemAuctionDetails[] items = {
            new ItemAuctionDetails(new ItemDetails("1", "nintendo"), 10.98, 1489333611 , 20.00),
            new ItemAuctionDetails(new ItemDetails("2", "nintendo 3ds"), 10.98, 1489333611 , 20.00),
            new ItemAuctionDetails(new ItemDetails("3", "nintendo 3ds xl"), 10.98, 1489333611 , 20.00)
        };
        return new ArrayList<>(Arrays.asList(items));
    }
    
}
