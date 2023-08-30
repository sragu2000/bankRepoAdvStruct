package com.bank.bank.service;

import com.bank.bank.model.CustomerModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerService {
    ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel);

    ResponseEntity<List<CustomerModel>> getAllCustomers();

    ResponseEntity<CustomerModel> findByID(@PathVariable long id);

    ResponseEntity<CustomerModel> deleteCustomerById(@PathVariable Long id);

    ResponseEntity<CustomerModel> updateCustomerById(@PathVariable Long id, @RequestBody CustomerModel customerModel);

    ResponseEntity<List<CustomerModel>> getAllCustomersByName(@RequestParam String name);

    ResponseEntity<List<CustomerModel>> getAllCustomersByNic(@RequestParam String nic);

    ResponseEntity<List<CustomerModel>> getAllCustomersByAddress(@RequestParam String address);

    ResponseEntity<List<CustomerModel>> getAllCustomersByProperties(@RequestParam(required = false) String name, @RequestParam(required = false) String nic, @RequestParam(required = false) String address);
}
