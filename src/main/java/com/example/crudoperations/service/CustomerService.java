package com.example.crudoperations.service;

import com.example.crudoperations.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> allCustomer();


    Customer findCustomerById(Long customerId);

    void deleteCustomer(Long customerId);

    Customer updatecustomer(Long customerId, Customer customer);

    Customer findCustomerByName(String customerName);
}
