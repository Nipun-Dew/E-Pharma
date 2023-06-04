package com.example.epharma.services;

import com.example.epharma.daos.OrderDAO;
import com.example.epharma.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> getOrders() {
        return orderDAO.findAll();
    }

    public void addNewOrder(Order order) {
        orderDAO.save(order);
    }
}
