package com.seneca.digitalvideostore.service;

import com.seneca.digitalvideostore.model.Customer;
import com.seneca.digitalvideostore.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final CustomerRepository repository;

    public CustomerService(BCryptPasswordEncoder passwordEncoder, CustomerRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public Customer registerCustomer(Customer customer) {
        String encodedPassword = passwordEncoder.encode(customer.getPassword());

        customer.setPassword(encodedPassword);
        return repository.save(customer);
    }

    public Customer getCustomerDetails(String customerEmail) {
        Optional<Customer> customerOptional = repository.findByEmail(customerEmail);
        if (customerOptional.isEmpty()) {
            throw new RuntimeException("No customer data found for customerEmail: " + customerEmail);
        }

        return customerOptional.get();
    }
}
