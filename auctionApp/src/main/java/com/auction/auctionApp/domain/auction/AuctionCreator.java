package com.auction.auctionApp.domain.auction;

import java.math.BigDecimal;

public interface AuctionCreator {

    void create(long accountId, String accountNumber, String title, long itemsCount, BigDecimal costOfAnItem);

}
