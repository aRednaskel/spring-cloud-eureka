package com.auction.auctionApp.domain;

import com.auction.auctionApp.api.order.OrderDto;

public interface BankAppClient {
    void execute(OrderDto orderDto);
}
