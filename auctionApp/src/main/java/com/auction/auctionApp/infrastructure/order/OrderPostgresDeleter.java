package com.auction.auctionApp.infrastructure.order;

import com.auction.auctionApp.domain.order.OrderDeleter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderPostgresDeleter implements OrderDeleter {

    private final OrderRepository orderRepository;

    @Override
    public void deleteOrderById(long orderId) {
        orderRepository.deleteById(orderId);
    }
}
