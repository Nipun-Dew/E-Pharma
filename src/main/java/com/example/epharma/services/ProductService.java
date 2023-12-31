package com.example.epharma.services;

import com.example.epharma.daos.ProductDAO;
import com.example.epharma.dtos.ProductRequest;
import com.example.epharma.dtos.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductDAO productDAO;
    private final ProductResponse productResponse;

    @Autowired
    public ProductService(ProductDAO productDAO, ProductResponse productResponse) {
        this.productDAO = productDAO;
        this.productResponse = productResponse;
    }

    public void addNewProduct(ProductRequest product) {
        productDAO.save(product.createProduct());
    }

    public List<ProductResponse> getProducts() {
        return productDAO.findAll().stream()
                .map(productResponse::createProductResponse).collect(Collectors.toList());
    }
}
