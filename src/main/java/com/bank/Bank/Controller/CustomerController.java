package com.bank.bank.controller;

import com.bank.bank.model.CustomerModel;
import com.bank.bank.repository.CustomerRepository;
import com.bank.bank.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerModel> createCustomer(@Valid  @RequestBody CustomerModel customerModel) {
        return customerService.createCustomer(customerModel);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CustomerModel>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<CustomerModel> findByID(@Valid @PathVariable long id){
        return customerService.findByID(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerModel> deleteCustomerById(@Valid @PathVariable Long id) {
        return customerService.deleteCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerModel> updateCustomerById(@Valid @PathVariable Long id, @RequestBody CustomerModel customerModel) {
        return customerService.updateCustomerById(id, customerModel);
    }

    @GetMapping("/get-all/name")
    public ResponseEntity<List<CustomerModel>> getAllCustomersByName(@Valid @RequestParam String name) {
        return customerService.getAllCustomersByName(name);
    }

    @GetMapping("/get-all/nic")
    public ResponseEntity<List<CustomerModel>> getAllCustomersByNic(@Valid @RequestParam String nic) {
        return customerService.getAllCustomersByNic(nic);
    }

    @GetMapping("/get-all/address")
    public ResponseEntity<List<CustomerModel>> getAllCustomersByAddress(@Valid @RequestParam String address) {
        return customerService.getAllCustomersByAddress(address);
    }

    @GetMapping("/get-all-by-properties")
    public ResponseEntity<List<CustomerModel>> getAllCustomersByProperties(@Valid @RequestParam(required = false) String name, @RequestParam(required = false) String nic, @RequestParam(required = false) String address) {
        return customerService.getAllCustomersByProperties(name, nic, address);
    }

}