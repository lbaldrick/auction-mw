package com.baldrick.auction.service;

import com.baldrick.auction.dto.ItemsSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baldrick.auction.dao.ItemAuctionDao;

@Service
public class ItemRetriever {
    
    @Autowired
    private final ItemAuctionDao datasource;

    public ItemRetriever(ItemAuctionDao datasource) {
        this.datasource = datasource;
    }
    
    public ItemsSearchResponse search(String query) {
        return new ItemsSearchResponse(this.datasource.getAuctionItems(null));
    }
}
