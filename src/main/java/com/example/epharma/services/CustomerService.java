package com.example.epharma.services;

import com.example.epharma.daos.CustomerDAO;
import com.example.epharma.dtos.CustomerRequest;
import com.example.epharma.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void addNewCustomer(CustomerRequest customer) {
        customerDAO.save(customer.createCustomer());
    }

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }
}
