package com.bank.bank.repository;
import com.bank.bank.model.AccountTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountTypeModel, Long> {
    AccountTypeModel save(AccountTypeModel accountTypeModel);

    List<AccountTypeModel> findAll();
}
