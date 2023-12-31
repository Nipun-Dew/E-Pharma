package com.example.epharma.dtos;

import com.example.epharma.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductResponse {
    private long id;
    private String name;
    private long productNumber;
    private long stockNumber;
    private long batchNumber;
    private String Manufacturer;
    private String productType;
    private LocalDate expiredDate;
    private LocalDate manufacturedDate;

    public ProductResponse() {}

    public ProductResponse createProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setProductNumber(product.getProductNumber());
        response.setStockNumber(product.getStockNumber());
        response.setBatchNumber(product.getBatchNumber());
        response.setManufacturer(product.getManufacturer());
        response.setProductType(product.getProductType());
        response.setExpiredDate(product.getExpiredDate());
        response.setManufacturedDate(product.getManufacturedDate());

        return response;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
    }

    public long getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(long stockNumber) {
        this.stockNumber = stockNumber;
    }

    public long getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(long batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(LocalDate manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }
}
