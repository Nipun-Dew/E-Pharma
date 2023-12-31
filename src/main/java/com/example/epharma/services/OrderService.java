package com.example.epharma.services;

import com.example.epharma.daos.CustomerDAO;
import com.example.epharma.daos.OrderDAO;
import com.example.epharma.daos.ProductDAO;
import com.example.epharma.dtos.OrderRequest;
import com.example.epharma.dtos.OrderResponse;
import com.example.epharma.model.Customer;
import com.example.epharma.model.Order;
import com.example.epharma.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

@Service
public class OrderService {
    private final OrderDAO orderDAO;
    private final CustomerDAO customerDAO;
    private final ProductDAO productDAO;

    private final OrderResponse orderResponse;

    @Autowired
    public OrderService(OrderDAO orderDAO,
                        CustomerDAO customerDAO,
                        ProductDAO productDAO,
                        OrderResponse orderResponse) {
        this.orderDAO = orderDAO;
        this.customerDAO = customerDAO;
        this.productDAO = productDAO;
        this.orderResponse = orderResponse;
    }

    public ResponseEntity<List<OrderResponse>> getOrders() {
        try {
            List<Order> orders = orderDAO.findAll();

            return ResponseEntity.ok(orders.stream().map(orderResponse::createOrderResponse)
                    .collect(Collectors.toList()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ArrayList<>());
        }
    }

    public ResponseEntity<OrderResponse> getOrderById(String id) {
        try {
            Optional<Order> optionalOrder = orderDAO.findById(parseLong(id));

            return optionalOrder.map(order -> ResponseEntity.ok(orderResponse.createOrderResponse(order)))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).body(new OrderResponse()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(orderResponse);
        }
    }

    public ResponseEntity<String> placeNewOrder(OrderRequest orderRequest) {
        try {
            return saveAnOrder(orderRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    public ResponseEntity<String> updateOrder(String id, OrderRequest orderRequest) {
        try {
            orderRequest.setId(parseLong(id));
            return saveAnOrder(orderRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    public ResponseEntity<String> updateOrderStatus(String id, String orderStatus) {
        try {
            Optional<Order> optionalOrder = orderDAO.findById(parseLong(id));

            if (optionalOrder.isPresent()) {
                Order newOrder = optionalOrder.get();
                newOrder.setOrderState(orderStatus);

                orderDAO.save(newOrder);

                return ResponseEntity.ok("Order State Successfully Updated!");
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    private ResponseEntity<String> saveAnOrder(OrderRequest orderRequest) {
        Optional<Customer> customer = customerDAO.findById(orderRequest.getCustomerId());
        Optional<Product> product = productDAO.findById(orderRequest.getProductId());

        if (customer.isPresent() && product.isPresent()) {
            Order newOrder = orderRequest
                    .createOrder(customer.get(), product.get());
            orderDAO.save(newOrder);

            return ResponseEntity.ok("Successfully Added!");
        } else {
            throw new NullPointerException();
        }
    }
}
