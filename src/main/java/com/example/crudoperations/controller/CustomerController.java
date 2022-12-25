package com.example.crudoperations.controller;

import com.example.crudoperations.entity.Customer;
import com.example.crudoperations.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@Valid @RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> allCustomer(){
        return customerService.allCustomer();
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable("id") Long customerId){
        return customerService.findCustomerById(customerId);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return "Customer Deleted!";
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer){
        return customerService.updatecustomer(customerId, customer);
    }

    @GetMapping("/customers/name/{name}")
    public Customer findByCustomerName(@PathVariable("name") String customerName){
        return customerService.findCustomerByName(customerName);
    }
}
