package com.bank.bank.controller;

import com.bank.bank.model.BankModel;
import com.bank.bank.model.CustomerModel;
import com.bank.bank.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
    @InjectMocks
    CustomerController customerController;
    @Mock
    CustomerService customerService;

    @Test
    void createCustomer_If_Correct(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        when(customerService.createCustomer(newCustomer)).thenReturn(expectedResponse);
        ResponseEntity<CustomerModel> response = customerController.createCustomer(newCustomer);
        assertEquals(expectedResponse, response);
    }

    @Test
    void createCustomer_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.createCustomer(newCustomer)).thenReturn(expectedResponse);
        ResponseEntity<CustomerModel> response = customerController.createCustomer(newCustomer);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomers_If_Correct(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomers()).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomers();
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomers_If_ThrowsError(){
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.getAllCustomers()).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomers();
        assertEquals(expectedResponse, response);
    }

    @Test
    void findByID_If_ValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        when(customerService.findByID(newCustomer.getId())).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.findByID(newCustomer.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void findByID_If_InValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(customerService.findByID(newCustomer.getId())).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.findByID(newCustomer.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void findByID_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.findByID(newCustomer.getId())).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.findByID(newCustomer.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateCustomerById_If_ValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        when(customerService.updateCustomerById(newCustomer.getId(), newCustomer)).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.updateCustomerById(newCustomer.getId(), newCustomer);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateCustomerById_If_InvalidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(customerService.updateCustomerById(newCustomer.getId(), newCustomer)).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.updateCustomerById(newCustomer.getId(), newCustomer);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateCustomerById_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.updateCustomerById(newCustomer.getId(), newCustomer)).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.updateCustomerById(newCustomer.getId(), newCustomer);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByName_If_Correct(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByName(newCustomer.getName())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByName(newCustomer.getName());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByName_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.getAllCustomersByName(newCustomer.getName())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByName(newCustomer.getName());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByAddress_If_Correct(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByAddress(newCustomer.getAddress())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByAddress(newCustomer.getAddress());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByAddress_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.getAllCustomersByAddress(newCustomer.getAddress())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByAddress(newCustomer.getAddress());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByNIC_If_Correct(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByNic(newCustomer.getNic())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByNic(newCustomer.getNic());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByNIC_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.getAllCustomersByNic(newCustomer.getNic())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByNic(newCustomer.getNic());
        assertEquals(expectedResponse, response);
    }

    @Test
    void deleteCustomerById_If_ValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        when(customerService.deleteCustomerById(newCustomer.getId())).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.deleteCustomerById(newCustomer.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void deleteCustomerById_If_InvalidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(customerService.deleteCustomerById(newCustomer.getId())).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.deleteCustomerById(newCustomer.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void deleteCustomerById_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<CustomerModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.deleteCustomerById(newCustomer.getId())).thenReturn(expectedResponse);
        ResponseEntity <CustomerModel> response = customerController.deleteCustomerById(newCustomer.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByProperties_If_NIC_Null_and_Address_null(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByProperties(newCustomer.getName(),null,null)).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByProperties(newCustomer.getName(),null,null);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByProperties_If_Name_Null_and_Address_null(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByProperties(null,newCustomer.getNic(),null)).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByProperties(null,newCustomer.getNic(),null);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByProperties_If_Name_Null_and_NIC_null(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByProperties(null,null,newCustomer.getAddress())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByProperties(null,null,newCustomer.getAddress());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByProperties_If_Address_Null(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByProperties(newCustomer.getName(),newCustomer.getNic(),null)).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByProperties(newCustomer.getName(), newCustomer.getNic(),null);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByProperties_If_NIC_Null(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByProperties(newCustomer.getName(),null, newCustomer.getAddress())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByProperties(newCustomer.getName(), null,newCustomer.getAddress());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByProperties_Else(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList.add(newCustomer);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(customerModelList, HttpStatus.CREATED);
        when(customerService.getAllCustomersByProperties(newCustomer.getName(),newCustomer.getNic(),newCustomer.getAddress())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByProperties(newCustomer.getName(), newCustomer.getNic(),newCustomer.getAddress());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllCustomersByProperties_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        ResponseEntity<List<CustomerModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(customerService.getAllCustomersByProperties(newCustomer.getName(),newCustomer.getNic(),newCustomer.getAddress())).thenReturn(expectedResponse);
        ResponseEntity<List<CustomerModel>> response = customerController.getAllCustomersByProperties(newCustomer.getName(), newCustomer.getNic(),newCustomer.getAddress());
        assertEquals(expectedResponse, response);
    }

}