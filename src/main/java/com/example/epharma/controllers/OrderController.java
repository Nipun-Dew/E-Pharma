package com.example.epharma.controllers;

import com.example.epharma.dtos.OrderRequest;
import com.example.epharma.model.Order;
import com.example.epharma.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="${api.prefix}")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    public ResponseEntity<String> placeNewOrder(@RequestBody OrderRequest order) {
        return orderService.placeNewOrder(order);
    }

    @PostMapping("/order/{id}")
    public ResponseEntity<String> UpdateEntireOrder(@PathVariable String id,
                                                    @RequestBody OrderRequest order) {
        return orderService.updateOrder(id, order);
    }

    @PostMapping("/order/state/{id}")
    public ResponseEntity<String> UpdateOrderStatus(@PathVariable String id,
                                                    @RequestParam String orderStatus) {
        return orderService.updateOrderStatus(id, orderStatus);
    }
}
