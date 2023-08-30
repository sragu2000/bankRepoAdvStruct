package com.bank.bank.controller;

import com.bank.bank.model.AccountTypeModel;
import com.bank.bank.repository.AccountTypeRepository;
import com.bank.bank.service.AccountTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/account-type")
public class AccountTypeController {
    @Autowired
    AccountTypeService accountTypeService;
    @Autowired
    AccountTypeRepository accountTypeRepository;

    @PostMapping("/save")
    public ResponseEntity<AccountTypeModel> createAccountType( @Valid @RequestBody AccountTypeModel accountTypeModel){
        return accountTypeService.createAccountType(accountTypeModel);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AccountTypeModel>> getAllAccountTypes() {
        return accountTypeService.getAllAccountTypes();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountTypeModel> deleteAccountTypeById(@Valid @PathVariable Long id) {
        return accountTypeService.deleteAccountTypeById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountTypeModel> updateAccountById( @PathVariable Long id , @RequestBody AccountTypeModel accountTypeModel){
        return accountTypeService.updateAccountById(id, accountTypeModel);
    }
}
