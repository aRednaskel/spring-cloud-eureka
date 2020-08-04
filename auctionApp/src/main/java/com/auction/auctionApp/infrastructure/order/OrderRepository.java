package com.auction.auctionApp.infrastructure.order;

import com.auction.auctionApp.domain.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<Order, Long> {
}
