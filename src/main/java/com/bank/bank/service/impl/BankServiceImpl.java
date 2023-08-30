package com.bank.bank.service.impl;

import com.bank.bank.model.BankModel;
import com.bank.bank.repository.BankRepository;
import com.bank.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankRepository bankRepository;
    @Override
    public ResponseEntity<BankModel> createBank(@RequestBody BankModel bankModel) {
        try {
            BankModel saveBankModel = bankRepository.save(bankModel);
            return new ResponseEntity<>(saveBankModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<BankModel>> getAllBanks() {
        try {
            List<BankModel> getAll = bankRepository.findAll();
            return  new ResponseEntity<>(getAll, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<BankModel>> getBankByLocation(String location) {
        try {
            List<BankModel> getBanks = bankRepository.findByLocation(location);
            return new ResponseEntity<>(getBanks, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BankModel> deleteBankById(@PathVariable Long id) {
        try{
            Optional<BankModel> optionalBankModel = bankRepository.findById(id);
            if(optionalBankModel.isPresent()){
                BankModel bankDeleted = optionalBankModel.get();
                bankRepository.deleteById(id);
                return new ResponseEntity<>(bankDeleted, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BankModel> updateBankById(@PathVariable Long id, @RequestBody BankModel bankModel) {
        try {
            Optional<BankModel> optionalBank = bankRepository.findById(id);
            System.out.println(optionalBank);
            if(optionalBank.isPresent()){
                BankModel getBank = optionalBank.get(); // it will return bank document if found
                getBank.setName(bankModel.getName());
                getBank.setLocation(bankModel.getLocation());
                BankModel updateCus = bankRepository.save(getBank);
                return new ResponseEntity<>(updateCus, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
