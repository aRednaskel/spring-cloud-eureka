package com.auction.auctionApp.domain.model.order;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
    private long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private long clientId;
    private long auctionId;
    private long auctionOwnerId;
    private long quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;


    public static Order createOrder(long clientId, long auctionId, long auctionOwnerId, long quantity, BigDecimal unitPrice) {
        return Order.builder()
                .clientId(clientId)
                .auctionId(auctionId)
                .auctionOwnerId(auctionOwnerId)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .totalPrice(calculateTotalPrice(unitPrice,quantity))
                .status(OrderStatus.PENDING)
                .build();
    }

    public static Order createOrderWithMaxTotalPrice(long clientId, long auctionId,long auctionOwnerId, BigDecimal unitPrice, BigDecimal totalPrice) {
        return Order.builder()
                .clientId(clientId)
                .auctionId(auctionId)
                .auctionOwnerId(auctionOwnerId)
                .quantity(calculateQuantity(unitPrice,totalPrice))
                .unitPrice(unitPrice)
                .totalPrice(totalPrice)
                .status(OrderStatus.PENDING).build();
    }

    private static BigDecimal calculateTotalPrice(BigDecimal unitPrice, long quantity) {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
    private static long calculateQuantity(BigDecimal unitPrice, BigDecimal totalPrice) {
        return unitPrice.divide(totalPrice).longValue();
    }
}
