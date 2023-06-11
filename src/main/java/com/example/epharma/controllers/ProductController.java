package com.example.epharma.controllers;

import com.example.epharma.dtos.CustomerRequest;
import com.example.epharma.dtos.ProductRequest;
import com.example.epharma.model.Customer;
import com.example.epharma.model.Product;
import com.example.epharma.services.CustomerService;
import com.example.epharma.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "${api.prefix}")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getOrders() {
        return productService.getProducts();
    }

    @PostMapping("/product")
    public void registerNewOrder(@RequestBody ProductRequest product) {
        productService.addNewProduct(product);
    }
}