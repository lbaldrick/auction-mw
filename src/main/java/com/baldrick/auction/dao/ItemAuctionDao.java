package com.baldrick.auction.dao;

import com.baldrick.auction.model.ItemAuctionDetails;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.rx.client.FindObservable;
import com.mongodb.rx.client.Success;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import rx.Observable;

public interface ItemAuctionDao {

  public Optional<Observable<Success>> createItem(ItemAuctionDetails item);

  public Observable<DeleteResult> deleteItem(String id);

  public Observable<Document> getAuctionItem(String id);

  public FindObservable<Document> getAuctionItems(List<String> ids);
}
