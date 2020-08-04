package com.auction.auctionApp.api.order;

import com.auction.auctionApp.domain.model.order.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class OrderDto {

    private long id;
    private OrderStatus status;
    private long clientId;
    private long auctionId;
    private long auctionOwnerId;
    private long quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

}
