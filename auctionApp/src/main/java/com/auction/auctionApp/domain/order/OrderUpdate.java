package com.auction.auctionApp.domain.order;

import com.auction.auctionApp.domain.model.order.OrderStatus;

public interface OrderUpdate {

    void changeOrderStatus(long orderId,OrderStatus orderStatus);
}
