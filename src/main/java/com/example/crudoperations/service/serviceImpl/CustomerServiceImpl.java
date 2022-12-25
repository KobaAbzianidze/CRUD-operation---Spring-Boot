package com.example.crudoperations.service.serviceImpl;

import com.example.crudoperations.entity.Customer;
import com.example.crudoperations.repository.CustomerRepository;
import com.example.crudoperations.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updatecustomer(Long customerId, Customer customer) {
        Customer changeCustomer = customerRepository.findById(customerId).get();

        if(Objects.nonNull(customer.getFirstName())&&"".equalsIgnoreCase(customer.getFirstName())){
            changeCustomer.setFirstName(customer.getFirstName());
        }
        if(Objects.nonNull(customer.getLastName())&&"".equalsIgnoreCase(customer.getLastName())){
            changeCustomer.setLastName(customer.getLastName());
        }
        if(Objects.nonNull(customer.getPhoneNumber())&&"".equalsIgnoreCase(customer.getPhoneNumber())){
            changeCustomer.setPhoneNumber(customer.getPhoneNumber());
        }
        return customerRepository.save(changeCustomer);
    }

    @Override
    public Customer findCustomerByName(String customerName) {
        return customerRepository.findByCustomerNameIgnoreCase(customerName);
    }


}
