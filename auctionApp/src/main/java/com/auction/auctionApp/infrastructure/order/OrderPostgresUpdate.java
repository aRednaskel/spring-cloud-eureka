package com.auction.auctionApp.infrastructure.order;

import com.auction.auctionApp.domain.model.order.Order;
import com.auction.auctionApp.domain.model.order.OrderStatus;
import com.auction.auctionApp.domain.order.OrderUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class OrderPostgresUpdate implements OrderUpdate {

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void changeOrderStatus(long orderId, OrderStatus orderStatus) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        order.setStatus(orderStatus);
    }
}
