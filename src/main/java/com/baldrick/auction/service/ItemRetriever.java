package com.baldrick.auction.service;

import com.baldrick.auction.dao.AuctionDao;
import com.baldrick.auction.dto.ItemsSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemRetriever {
    
    @Autowired
    private final AuctionDao datasource;

    public ItemRetriever(AuctionDao datasource) {
        this.datasource = datasource;
    }
    
    public ItemsSearchResponse search(String query) {
        return new ItemsSearchResponse(this.datasource.getAuctionItems(null));
    }
}
