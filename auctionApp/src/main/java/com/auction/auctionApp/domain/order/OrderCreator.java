package com.auction.auctionApp.domain.order;

import java.math.BigDecimal;

public interface OrderCreator {

    void create(long clientId, long auctionId,long auctionOwnerId, long quantity, BigDecimal unitPrice);

    void createWithTotalPrice(long clientId, long auctionId,long auctionOwnerId, BigDecimal unitPrice, BigDecimal totalPrice);

}
