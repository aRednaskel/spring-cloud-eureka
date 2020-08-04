package com.auction.auctionApp.infrastructure.order;

import com.auction.auctionApp.domain.model.order.Order;
import com.auction.auctionApp.domain.order.OrderCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
class OrderPostgresCreator implements OrderCreator {

    private final OrderRepository orderRepository;

    @Override
    public void create(long clientId, long auctionId, long auctionOwnerId, long quantity, BigDecimal unitPrice) {
        Order order = Order.createOrder(clientId, auctionId, auctionOwnerId, quantity, unitPrice);
        orderRepository.save(order);
    }

    @Override
    public void createWithTotalPrice(long clientId, long auctionId, long auctionOwnerId, BigDecimal unitPrice, BigDecimal totalPrice) {
        Order order = Order.createOrderWithMaxTotalPrice(clientId, auctionId, auctionOwnerId, unitPrice, totalPrice);
        orderRepository.save(order);
    }
}
