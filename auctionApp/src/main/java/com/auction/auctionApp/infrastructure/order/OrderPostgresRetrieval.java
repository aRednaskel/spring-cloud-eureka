package com.auction.auctionApp.infrastructure.order;

import com.auction.auctionApp.api.order.OrderDto;
import com.auction.auctionApp.domain.model.order.Order;
import com.auction.auctionApp.domain.model.order.OrderStatus;
import com.auction.auctionApp.domain.order.OrderRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class OrderPostgresRetrieval implements OrderRetrieval {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> findByAuctionOwnerId(long auctionOwnerId) {
        return OrderMapper.mapOrderListToDto(
                orderRepository.findAll().stream()
                .filter(order -> order.getAuctionOwnerId() == auctionOwnerId)
                .collect(Collectors.toList()));
    }

    @Override
    public List<OrderDto> findAll() {
        return OrderMapper.mapOrderListToDto(orderRepository.findAll());
    }

    @Override
    public List<OrderDto> findAllPendingOrders() {
        return OrderMapper.mapOrderListToDto(
                orderRepository.findAll().stream()
                        .filter(order -> order.getStatus() == OrderStatus.PENDING)
                        .collect(Collectors.toList()));
    }

    private static class OrderMapper {
        private static OrderDto mapToDto(Order order) {
            return OrderDto.builder()
                    .auctionId(order.getAuctionId())
                    .auctionOwnerId(order.getAuctionOwnerId())
                    .clientId(order.getClientId())
                    .quantity(order.getQuantity())
                    .status(order.getStatus())
                    .unitPrice(order.getUnitPrice())
                    .totalPrice(order.getTotalPrice()).build();
        }

        private static List<OrderDto> mapOrderListToDto(List<Order> orders) {
            List<OrderDto> dtoOrders = orders.stream()
                    .map(OrderMapper::mapToDto).collect(Collectors.toList());
            return dtoOrders;
        }
    }
}
