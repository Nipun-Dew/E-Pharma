package com.example.epharma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity @Table(name="t_order")
public class Order {
    @Id @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private long id;
    private int orderNumber;
    private String customer;
    private String customerType;
    private double unitPrice;

    private int quantity;

    private String product;
    private int productNumber;
    private LocalDate issuedDate;
    private String orderState;
    public Order() {
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double payment) {
        this.unitPrice = payment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", customer='" + customer + '\'' +
                ", customerType='" + customerType + '\'' +
                ", payment=" + unitPrice +
                ", product='" + product + '\'' +
                ", productNumber=" + productNumber +
                ", issuedDate=" + issuedDate +
                ", orderState='" + orderState + '\'' +
                '}';
    }
}
