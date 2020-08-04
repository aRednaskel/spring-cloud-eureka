package com.auction.auctionApp.domain.auction;

import java.math.BigDecimal;

public interface AuctionUpdate {

    void changeTitle(long auctionId, String title);

    void changeCostOfItem(long auctionId, BigDecimal costOfItem);

}
