package com.example.epharma.dtos;

import com.example.epharma.model.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrderResponse {
    private long id;
    private int orderNumber;
    private long customerId;
    private long productId;
    private double unitPrice;
    private int quantity;
    private long productNumber;
    private LocalDate issuedDate;
    private String orderState;

    public OrderResponse() {}

    public OrderResponse createOrderResponse(Order order) {
        OrderResponse newOrderResp = new OrderResponse();
        newOrderResp.setId(order.getId());
        newOrderResp.setCustomerId(order.getCustomer().getId());
        newOrderResp.setProductId(order.getProduct().getId());
        newOrderResp.setUnitPrice(order.getUnitPrice());
        newOrderResp.setQuantity(order.getQuantity());
        newOrderResp.setProductNumber(order.getProduct().getProductNumber());
        newOrderResp.setIssuedDate(order.getIssuedDate());
        newOrderResp.setOrderState(order.getOrderState());

        return newOrderResp;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
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
