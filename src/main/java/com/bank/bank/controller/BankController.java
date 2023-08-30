package com.bank.bank.controller;
import com.bank.bank.model.BankModel;
import com.bank.bank.repository.BankRepository;
import com.bank.bank.service.BankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankRepository bankRepository;

    @Autowired
    BankService bankServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<BankModel> createBank(@Valid  @RequestBody BankModel bankModel) {
        return bankServiceImpl.createBank(bankModel);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BankModel>> getAllBanks() {
        return bankServiceImpl.getAllBanks();
    }

    @GetMapping("/get-all/location")
    public ResponseEntity<List<BankModel>> getBankByLocation(@Valid String location) {
        return bankServiceImpl.getBankByLocation(location);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BankModel> deleteBankById(@Valid @PathVariable Long id) {
        return bankServiceImpl.deleteBankById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BankModel> updateBankById(@Valid @PathVariable Long id, @RequestBody BankModel bankModel) {
        return bankServiceImpl.updateBankById(id,bankModel);
    }
}