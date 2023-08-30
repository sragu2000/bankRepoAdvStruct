package com.bank.bank.service;

import com.bank.bank.model.BankModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BankService {
    ResponseEntity<BankModel> createBank(@RequestBody BankModel bankModel);

    ResponseEntity<List<BankModel>> getAllBanks();

    ResponseEntity<List<BankModel>> getBankByLocation(String location);

    ResponseEntity<BankModel> deleteBankById(@PathVariable Long id);

    ResponseEntity<BankModel> updateBankById(@PathVariable Long id, @RequestBody BankModel bankModel);
}
