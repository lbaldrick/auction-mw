package com.baldrick.auction.controller;

import com.baldrick.auction.dto.ItemsSearchResponse;
import com.baldrick.auction.service.ItemRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemsController {
    
    @Autowired
    private final ItemRetriever itemRetrieverService;
    
    public ItemsController(ItemRetriever itemRetrieverService) {
        this.itemRetrieverService = itemRetrieverService;
    }

    @RequestMapping(value = "/{query}", method = RequestMethod.GET)
    public ItemsSearchResponse search(@PathVariable String query) {
        return this.itemRetrieverService.search(query);
    }
    
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String getItem(@PathVariable String query) {
        return query;
    }

}
