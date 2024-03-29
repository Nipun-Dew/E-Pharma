package com.example.epharma.dtos;

import com.example.epharma.model.Customer;
import com.example.epharma.utils.CustomerType;

public class CustomerRequest {
    private long id;
    private String name;
    private long registrationNo;
    private String customerType;
    private String contactNo;
    private String address;

    public CustomerRequest() {
    }

    public Customer createCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setId(id);
        newCustomer.setName(name);
        newCustomer.setRegistrationNo(registrationNo);
        newCustomer.setCustomerType(CustomerType.valueOf(customerType));
        newCustomer.setContactNo(contactNo);
        newCustomer.setAddress(address);

        return newCustomer;
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

    public long getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(long registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
