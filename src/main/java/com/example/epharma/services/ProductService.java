package com.example.epharma.services;

import com.example.epharma.daos.ProductDAO;
import com.example.epharma.dtos.CustomerRequest;
import com.example.epharma.dtos.ProductRequest;
import com.example.epharma.model.Customer;
import com.example.epharma.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addNewProduct(ProductRequest product) {
        productDAO.save(product.createProduct());
    }

    public List<Product> getProducts() {
        return productDAO.findAll();
    }
}
