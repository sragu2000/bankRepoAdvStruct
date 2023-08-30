package com.bank.bank.controller;

import com.bank.bank.model.AccountModel;
import com.bank.bank.model.AccountTypeModel;
import com.bank.bank.model.BankModel;
import com.bank.bank.model.CustomerModel;
import com.bank.bank.service.AccountService;
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
class AccountControllerTest {
    @InjectMocks
    AccountController accountController;

    @Mock
    AccountService accountService;

    @Test
    void createAccount_If_Correct() {
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        when(accountService.createAccount(newAccount)).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.createAccount(newAccount);
        assertEquals(expectedResponse, response);
    }

    @Test
    void createAccount_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountService.createAccount(newAccount)).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.createAccount(newAccount);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllAccounts_If_Correct(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        List<AccountModel> accountList = new ArrayList<>();
        accountList.add(newAccount);
        ResponseEntity<List<AccountModel>> expectedResponse = new ResponseEntity<>(accountList, HttpStatus.CREATED);
        when(accountService.getAllAccounts()).thenReturn(expectedResponse);
        ResponseEntity<List<AccountModel>> response = accountController.getAllAccounts();
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllAccounts_If_ThrowsError(){
        ResponseEntity<List<AccountModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountService.getAllAccounts()).thenReturn(expectedResponse);
        ResponseEntity<List<AccountModel>> response = accountController.getAllAccounts();
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateAccountById_If_ValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        when(accountService.updateAccountById(newAccount.getId(), newAccount)).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.updateAccountById(newAccount.getId(), newAccount);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateAccountById_If_InvalidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(accountService.updateAccountById(newAccount.getId(), newAccount)).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.updateAccountById(newAccount.getId(), newAccount);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateAccountById_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(accountService.updateAccountById(newAccount.getId(), newAccount)).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.updateAccountById(newAccount.getId(), newAccount);
        assertEquals(expectedResponse, response);
    }

    @Test
    void DeleteAccountById_If_ValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        when(accountService.deleteAccountById(newAccount.getId())).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.deleteAccountById(newAccount.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void DeleteAccountById_If_InValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(accountService.deleteAccountById(newAccount.getId())).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.deleteAccountById(newAccount.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void DeleteAccountById_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<AccountModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountService.deleteAccountById(newAccount.getId())).thenReturn(expectedResponse);
        ResponseEntity<AccountModel> response = accountController.deleteAccountById(newAccount.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getBalanceById_If_ValidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<Double> expectedResponse = new ResponseEntity<>(newAccount.getBalance(), HttpStatus.CREATED);
        when(accountService.getBalanceById(newAccount.getId())).thenReturn(expectedResponse);
        ResponseEntity<Double> response = accountController.getBalanceById(newAccount.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getBalanceById_If_InvalidID(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<Double> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(accountService.getBalanceById(newAccount.getId())).thenReturn(expectedResponse);
        ResponseEntity<Double> response = accountController.getBalanceById(newAccount.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getBalanceById_If_ThrowsError(){
        BankModel newBank = new BankModel(123,"BOC","Colombo");
        AccountTypeModel newAccountType = new AccountTypeModel(12, "Current");
        CustomerModel newCustomer = new CustomerModel(12,"ABC","US","Colombo",12345, newBank);
        AccountModel newAccount = new AccountModel(12, newCustomer, newAccountType, 34000.0);
        ResponseEntity<Double> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountService.getBalanceById(newAccount.getId())).thenReturn(expectedResponse);
        ResponseEntity<Double> response = accountController.getBalanceById(newAccount.getId());
        assertEquals(expectedResponse, response);
    }

}