package com.auction.auctionApp.domain.order;

import com.auction.auctionApp.api.order.OrderDto;
import com.auction.auctionApp.domain.model.order.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderCreator orderCreator;
    private final OrderRetrieval orderRetrieval;
    private final OrderUpdate orderUpdate;
    private final OrderDeleter orderDeleter;

    public void create(long clientId, long auctionId, long auctionOwnerId, long quantity, BigDecimal unitPrice) {
        orderCreator.create(clientId, auctionId, auctionOwnerId, quantity, unitPrice);
    }

    public void createWithTotalPrice(long clientId, long auctionId, long auctionOwnerId, BigDecimal unitPrice, BigDecimal totalPrice) {
        orderCreator.createWithTotalPrice(clientId, auctionId, auctionOwnerId, unitPrice, totalPrice);
    }

    public List<OrderDto> findByAuctionOwnerId(long auctionOwnerId) {
        return orderRetrieval.findByAuctionOwnerId(auctionOwnerId);
    }

    public List<OrderDto> findAll() {
        return orderRetrieval.findAll();
    }

    public List<OrderDto> findAllPendingOrder() {
        return orderRetrieval.findAllPendingOrders();
    }

    public void changeOrderStatus(long orderId, OrderStatus orderStatus) {
        orderUpdate.changeOrderStatus(orderId, orderStatus);
    }

    public void deleteOderById(long orderId) {
        orderDeleter.deleteOrderById(orderId);
    }


}

