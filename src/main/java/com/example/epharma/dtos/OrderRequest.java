package com.example.epharma.dtos;

import com.example.epharma.model.Customer;
import com.example.epharma.model.Order;
import com.example.epharma.model.Product;
import com.example.epharma.utils.OrderStatus;

import java.time.LocalDate;

public class OrderRequest {
    private long id;
    private int orderNumber;
    private long customerId;
    private long productId;
    private double unitPrice;
    private int quantity;
    private int productNumber;
    private LocalDate issuedDate;
    private String orderState;

    public OrderRequest() {
    }

    public Order createOrder(Customer customer, Product product) {
        Order newOrder = new Order();
        newOrder.setId(id);
        newOrder.setOrderNumber(orderNumber);
        newOrder.setCustomer(customer);
        newOrder.setUnitPrice(unitPrice);
        newOrder.setQuantity(quantity);
        newOrder.setProduct(product);
        newOrder.setIssuedDate(issuedDate);
        newOrder.setOrderState(OrderStatus.valueOf(orderState));

        return newOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}
