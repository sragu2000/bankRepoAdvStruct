package com.bank.Bank.Repository;
import com.bank.Bank.Model.AccountTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTypeRepository extends JpaRepository<AccountTypeModel, Long> {
    AccountTypeModel save(AccountTypeModel accountTypeModel);

    List<AccountTypeModel> findAll();
}
