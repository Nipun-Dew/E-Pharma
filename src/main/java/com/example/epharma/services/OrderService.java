package com.example.epharma.services;

import com.example.epharma.daos.CustomerDAO;
import com.example.epharma.daos.OrderDAO;
import com.example.epharma.daos.ProductDAO;
import com.example.epharma.dtos.OrderRequest;
import com.example.epharma.model.Customer;
import com.example.epharma.model.Order;
import com.example.epharma.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.parseLong;

@Service
public class OrderService {
    private final OrderDAO orderDAO;
    private final CustomerDAO customerDAO;
    private final ProductDAO productDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO, CustomerDAO customerDAO, ProductDAO productDAO) {
        this.orderDAO = orderDAO;
        this.customerDAO = customerDAO;
        this.productDAO = productDAO;
    }

    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderDAO.findAll());
    }

    public ResponseEntity<Order> getOrderById(String id) {
        Optional<Order> optionalOrder = orderDAO.findById(parseLong(id));

        if(optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Order());
        }
    }

    public ResponseEntity<String> placeNewOrder(OrderRequest orderRequest) {
        try {
            return saveAnOrder(orderRequest);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    public ResponseEntity<String> updateOrder(String id, OrderRequest orderRequest) {
        try {
            orderRequest.setId(parseLong(id));
            return saveAnOrder(orderRequest);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    public ResponseEntity<String> updateOrderStatus(String id, String orderStatus) {
        try {
            Optional<Order> optionalOrder = orderDAO.findById(parseLong(id));

            if(optionalOrder.isPresent()) {
                Order newOrder = optionalOrder.get();
                newOrder.setOrderState(orderStatus);

                orderDAO.save(newOrder);

                return ResponseEntity.ok("Order State Successfully Updated!");
            } else {
                throw new NullPointerException();
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    private ResponseEntity<String> saveAnOrder(OrderRequest orderRequest) {
        Optional<Customer> customer = customerDAO.findById(orderRequest.getCustomerId());
        Optional<Product> product = productDAO.findById(orderRequest.getProductId());

        if(customer.isPresent() && product.isPresent()) {
            Order newOrder = orderRequest
                    .createOrder(customer.get(), product.get());
            orderDAO.save(newOrder);

            return ResponseEntity.ok("Successfully Added!");
        } else {
            throw new NullPointerException();
        }
    }
}
