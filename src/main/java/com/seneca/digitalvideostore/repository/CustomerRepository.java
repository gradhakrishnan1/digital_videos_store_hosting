package com.seneca.digitalvideostore.repository;

import com.seneca.digitalvideostore.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByEmail(String customerEmail);
}
