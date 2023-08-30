package com.bank.bank.service;

import com.bank.bank.model.AccountTypeModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AccountTypeService {
    ResponseEntity<AccountTypeModel> createAccountType(AccountTypeModel accountTypeModel);

    ResponseEntity<List<AccountTypeModel>> getAllAccountTypes();

    ResponseEntity<AccountTypeModel> deleteAccountTypeById(@PathVariable Long id);

    ResponseEntity<AccountTypeModel> updateAccountById(Long id, AccountTypeModel accountTypeModel);
}
