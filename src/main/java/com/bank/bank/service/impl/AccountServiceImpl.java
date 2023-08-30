package com.bank.bank.service.impl;

import com.bank.bank.model.AccountModel;
import com.bank.bank.repository.AccountRepository;
import com.bank.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public ResponseEntity<AccountModel> createAccount(@RequestBody AccountModel accountModel) {
        try {
            AccountModel saveAccountModel = accountRepository.save(accountModel);
            return new ResponseEntity<>(saveAccountModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<AccountModel>> getAllAccounts() {
        try {
            List<AccountModel> getAll = accountRepository.findAll();
            return new ResponseEntity<>(getAll, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<AccountModel> deleteAccountById(@PathVariable Long id) {
        try{
            Optional<AccountModel> optionalAccountModel= accountRepository.findById(id);
            if(optionalAccountModel.isPresent()){
                accountRepository.deleteById(id);
                return new ResponseEntity<>(optionalAccountModel.get(), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<AccountModel> updateAccountById(@PathVariable Long id, @RequestBody AccountModel accountModel){
        try{
            Optional<AccountModel> optionalAccount = accountRepository.findById(id);
            if(optionalAccount.isPresent()){
                AccountModel availableAccount = optionalAccount.get();
                availableAccount.setCustomerModel(accountModel.getCustomerModel());
                availableAccount.setAccountTypeModel(accountModel.getAccountTypeModel());
                availableAccount.setBalance(accountModel.getBalance());
                AccountModel updatedAccount = accountRepository.save(availableAccount);
                return new ResponseEntity<>(updatedAccount, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Double> getBalanceById(@PathVariable Long id){
        try{
            Optional<AccountModel> optionalAccount = accountRepository.findById(id);
            if(optionalAccount.isPresent()){
                AccountModel availableAccount = optionalAccount.get();
                return new ResponseEntity<>(availableAccount.getBalance(), HttpStatus.CREATED);
            } else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
