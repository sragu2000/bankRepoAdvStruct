package com.bank.bank.repository;
import com.bank.bank.model.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BankRepository extends JpaRepository<BankModel,Long>{
    BankModel save(BankModel bankModel);
    List<BankModel> findAll();
    List<BankModel> findByLocation(String location);
}