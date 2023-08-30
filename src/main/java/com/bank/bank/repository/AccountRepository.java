package com.bank.bank.repository;
import com.bank.bank.model.AccountModel;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    AccountModel save(AccountModel accountModel);
    List<AccountModel> findAll();

}