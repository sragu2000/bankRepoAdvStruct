package com.bank.bank.controller;

import com.bank.bank.model.AccountTypeModel;
import com.bank.bank.service.AccountTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountTypeControllerTest {
    @InjectMocks
    AccountTypeController accountTypeController;
    @Mock
    AccountTypeService accountTypeService;

    @Test
    void createAccountType_If_Correct(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(newAccountType, HttpStatus.CREATED);
        when(accountTypeService.createAccountType(newAccountType)).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.createAccountType(newAccountType);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createAccountType_If_ThrowsError(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountTypeService.createAccountType(newAccountType)).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.createAccountType(newAccountType);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getAllAccountTypes_If_Correct(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        List<AccountTypeModel> accountTypeList = new ArrayList<>();
        accountTypeList.add(newAccountType);
        ResponseEntity<List<AccountTypeModel>> expectedResponse = new ResponseEntity<>(accountTypeList, HttpStatus.CREATED);
        when(accountTypeService.getAllAccountTypes()).thenReturn(expectedResponse);
        ResponseEntity<List<AccountTypeModel>> actualResponse = accountTypeController.getAllAccountTypes();
        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    void getAllAccountTypes_If_ThrowsError(){
        ResponseEntity<List<AccountTypeModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountTypeService.getAllAccountTypes()).thenReturn(expectedResponse);
        ResponseEntity<List<AccountTypeModel>> actualResponse = accountTypeController.getAllAccountTypes();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void deleteAccountTypeById_If_ValidID(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(newAccountType, HttpStatus.CREATED);
        when(accountTypeService.deleteAccountTypeById(newAccountType.getId())).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.deleteAccountTypeById(newAccountType.getId());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void deleteAccountTypeById_If_InValidID(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(accountTypeService.deleteAccountTypeById(newAccountType.getId())).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.deleteAccountTypeById(newAccountType.getId());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void deleteAccountTypeById_If_ThrowsError(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountTypeService.deleteAccountTypeById(newAccountType.getId())).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.deleteAccountTypeById(newAccountType.getId());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void updateAccountById_If_ValidID(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(newAccountType, HttpStatus.CREATED);
        when(accountTypeService.updateAccountById(newAccountType.getId(), newAccountType)).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.updateAccountById(newAccountType.getId(), newAccountType);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void updateAccountById_If_InvalidID(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(newAccountType, HttpStatus.NOT_FOUND);
        when(accountTypeService.updateAccountById(newAccountType.getId(), newAccountType)).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.updateAccountById(newAccountType.getId(), newAccountType);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void updateAccountByIdIfThrowsError(){
        AccountTypeModel newAccountType = new AccountTypeModel(1, "Savings Account");
        ResponseEntity<AccountTypeModel> expectedResponse = new ResponseEntity<>(newAccountType, HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountTypeService.updateAccountById(newAccountType.getId(), newAccountType)).thenReturn(expectedResponse);
        ResponseEntity<AccountTypeModel> actualResponse = accountTypeController.updateAccountById(newAccountType.getId(), newAccountType);
        assertEquals(expectedResponse, actualResponse);
    }

}