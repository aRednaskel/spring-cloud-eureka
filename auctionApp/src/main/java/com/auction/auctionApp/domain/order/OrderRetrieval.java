package com.auction.auctionApp.domain.order;

import com.auction.auctionApp.api.order.OrderDto;

import java.util.List;

public interface OrderRetrieval {

    List<OrderDto> findByAuctionOwnerId(long auctionOwnerId);

    List<OrderDto> findAll();

    List<OrderDto> findAllPendingOrders();
}
