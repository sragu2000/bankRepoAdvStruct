package com.bank.bank.service;

import com.bank.bank.model.AccountModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountService {
    ResponseEntity<AccountModel> createAccount(@RequestBody AccountModel accountModel);

    ResponseEntity<List<AccountModel>> getAllAccounts();

    ResponseEntity<AccountModel> deleteAccountById(@PathVariable Long id);

    ResponseEntity<AccountModel> updateAccountById(@PathVariable Long id, @RequestBody AccountModel accountModel);

    ResponseEntity<Double> getBalanceById(@PathVariable Long id);
}
