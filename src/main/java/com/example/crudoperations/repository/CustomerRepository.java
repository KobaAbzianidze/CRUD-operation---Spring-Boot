package com.example.crudoperations.repository;

import com.example.crudoperations.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByCustomerName(String customerName);
    public Customer findByCustomerNameIgnoreCase(String customerName);
}
