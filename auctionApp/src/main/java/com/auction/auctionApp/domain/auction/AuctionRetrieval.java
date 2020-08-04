package com.auction.auctionApp.domain.auction;

import com.auction.auctionApp.domain.model.auction.Auction;

import java.util.List;

public interface AuctionRetrieval {

    List<Auction> getByAccountId(long accountId);

    List<Auction> findAll();
}
