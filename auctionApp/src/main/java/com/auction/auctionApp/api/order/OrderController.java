package com.auction.auctionApp.api.order;

import com.auction.auctionApp.domain.model.order.OrderStatus;
import com.auction.auctionApp.domain.order.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/orders")
public class OrderController {

    private final OrderFacade orderFacade;

    @PostMapping(path = "/create")
    public void create(@RequestBody OrderDto orderDto) {
        orderFacade.create(orderDto.getClientId(), orderDto.getAuctionId(), orderDto.getAuctionOwnerId(), orderDto.getQuantity(), orderDto.getUnitPrice());
    }
    @PostMapping(path = "/create/totalprice")
    public void createWithTotalPrice(@RequestBody OrderDto orderDto) {
        orderFacade.createWithTotalPrice(orderDto.getClientId(), orderDto.getAuctionId(), orderDto.getAuctionOwnerId(), orderDto.getUnitPrice(), orderDto.getTotalPrice());
    }

    @GetMapping(path = "/{auctionOwnerId}")
    public ResponseEntity<List<OrderDto>> findByAuctionOwnerId(@PathVariable long auctionOwnerId) {
        return ResponseEntity.ok(orderFacade.findByAuctionOwnerId(auctionOwnerId));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        return ResponseEntity.ok(orderFacade.findAll());
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAllPendingOrders() {
        return ResponseEntity.ok(orderFacade.findAllPendingOrder());
    }

    @PatchMapping(path = "/changestatus")
    public void changeOrderStatus(@RequestParam long orderId, @RequestParam OrderStatus orderStatus) {
        orderFacade.changeOrderStatus(orderId, orderStatus);
    }

    @DeleteMapping(path = "/delete/{orderId}")
    public void deleteOrderById(@PathVariable long orderId) {
        orderFacade.deleteOderById(orderId);
    }

}
