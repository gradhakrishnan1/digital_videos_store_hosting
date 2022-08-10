package com.seneca.digitalvideostore.controller;

import com.seneca.digitalvideostore.model.Customer;
import com.seneca.digitalvideostore.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody @Valid Customer customer) {
        return ResponseEntity.ok(service.registerCustomer(customer));
    }

    @PostMapping("/details")
    public ResponseEntity<Customer> getCustomerDetails(@RequestParam String customerEmail) {
        return ResponseEntity.ok(service.getCustomerDetails(customerEmail));
    }
}
