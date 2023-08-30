package com.bank.bank.controller;

import com.bank.bank.model.BankModel;
import com.bank.bank.service.BankService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankControllerTest {
    @InjectMocks
    BankController bankController;

    @Mock
    BankService bankServiceImpl;

    @Test
    void createBank_If_Correct(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(newBank, HttpStatus.CREATED);
        when(bankServiceImpl.createBank(newBank)).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.createBank(newBank);
        assertEquals(expectedResponse, response);
    }

    @Test
    void createBank_If_ThrowsError(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(bankServiceImpl.createBank(newBank)).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.createBank(newBank);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllBanks_If_Correct(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        List<BankModel> bankList = new ArrayList<>();
        bankList.add(newBank);
        ResponseEntity<List<BankModel>> expectedResponse = new ResponseEntity<>(bankList, HttpStatus.CREATED);
        when(bankServiceImpl.getAllBanks()).thenReturn(expectedResponse);
        ResponseEntity<List<BankModel>> response = bankController.getAllBanks();
        assertEquals(expectedResponse, response);
    }

    @Test
    void getAllBanks_If_ThrowsError(){
        ResponseEntity<List<BankModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(bankServiceImpl.getAllBanks()).thenReturn(expectedResponse);
        ResponseEntity<List<BankModel>> response = bankController.getAllBanks();
        assertEquals(expectedResponse, response);
    }

    @Test
    void getBankByLocation_If_Correct(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        List<BankModel> bankList = new ArrayList<>();
        bankList.add(newBank);
        ResponseEntity<List<BankModel>> expectedResponse = new ResponseEntity<>(bankList, HttpStatus.CREATED);
        when(bankServiceImpl.getBankByLocation(newBank.getLocation())).thenReturn(expectedResponse);
        ResponseEntity<List<BankModel>> response = bankController.getBankByLocation(newBank.getLocation());
        assertEquals(expectedResponse, response);
    }

    @Test
    void getBankByLocation_If_ThrowsError(){
        ResponseEntity<List<BankModel>> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(bankServiceImpl.getBankByLocation("Kandy")).thenReturn(expectedResponse);
        ResponseEntity<List<BankModel>> response = bankController.getBankByLocation("Kandy");
        assertEquals(expectedResponse, response);
    }

    @Test
    void deleteBankById_If_ValidID(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(newBank, HttpStatus.CREATED);
        when(bankServiceImpl.deleteBankById(newBank.getId())).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.deleteBankById(newBank.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void deleteBankById_If_InValidID(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(bankServiceImpl.deleteBankById(newBank.getId())).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.deleteBankById(newBank.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void deleteBankById_If_ThrowsError(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(bankServiceImpl.deleteBankById(newBank.getId())).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.deleteBankById(newBank.getId());
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateBankById_If_ValidID(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(newBank, HttpStatus.CREATED);
        when(bankServiceImpl.updateBankById(newBank.getId(), newBank)).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.updateBankById(newBank.getId(), newBank);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateBankById_If_InValidID(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(bankServiceImpl.updateBankById(newBank.getId(), newBank)).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.updateBankById(newBank.getId(), newBank);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateBankById_If_ThrowsError(){
        BankModel newBank = new BankModel(1, "NSB", "Colombo");
        ResponseEntity<BankModel> expectedResponse = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        when(bankServiceImpl.updateBankById(newBank.getId(), newBank)).thenReturn(expectedResponse);
        ResponseEntity<BankModel> response = bankController.updateBankById(newBank.getId(), newBank);
        assertEquals(expectedResponse, response);
    }

}