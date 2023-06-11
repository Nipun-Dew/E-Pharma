package com.example.epharma.services;

import com.example.epharma.daos.CustomerDAO;
import com.example.epharma.daos.OrderDAO;
import com.example.epharma.daos.ProductDAO;
import com.example.epharma.dtos.OrderRequest;
import com.example.epharma.model.Customer;
import com.example.epharma.model.Order;
import com.example.epharma.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Order> getOrders() {
        return orderDAO.findAll();
    }

    public void addNewOrder(OrderRequest orderRequest) {
        try {
            Optional<Customer> customer = customerDAO.findById(orderRequest.getCustomerId());
            Optional<Product> product = productDAO.findById(orderRequest.getProductId());

            if(customer.isPresent() && product.isPresent()) {
                Order newOrder = orderRequest
                        .createOrder(customer.get(), product.get());
                orderDAO.save(newOrder);
            } else {
                throw new NullPointerException();
            }
        } catch(Exception ignored) {}
    }
}
