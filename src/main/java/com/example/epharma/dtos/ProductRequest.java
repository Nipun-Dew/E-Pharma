package com.example.epharma.dtos;

import com.example.epharma.model.Product;

import java.time.LocalDate;

public class ProductRequest {
    private String name;
    private long productNumber;
    private long stockNumber;
    private long batchNumber;
    private String Manufacturer;
    private String productType;
    private LocalDate expiredDate;
    private LocalDate manufacturedDate;

    public ProductRequest() {
    }

    public Product createProduct() {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setProductNumber(productNumber);
        newProduct.setStockNumber(stockNumber);
        newProduct.setBatchNumber(batchNumber);
        newProduct.setManufacturer(Manufacturer);
        newProduct.setProductType(productType);
        newProduct.setExpiredDate(expiredDate);
        newProduct.setManufacturedDate(manufacturedDate);

        return newProduct;
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
