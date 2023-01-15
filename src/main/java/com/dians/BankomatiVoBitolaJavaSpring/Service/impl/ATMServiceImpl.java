package com.dians.BankomatiVoBitolaJavaSpring.Service.impl;

import com.dians.BankomatiVoBitolaJavaSpring.Model.ATM;
import com.dians.BankomatiVoBitolaJavaSpring.Repository.ATMRepository;
import com.dians.BankomatiVoBitolaJavaSpring.Service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ATMServiceImpl implements ATMService {


    private final ATMRepository atmRepository;

    @Autowired
    public ATMServiceImpl(ATMRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    public List<ATM> getAllAtm() {
        List<ATM> allATMs = atmRepository.findAll();
        return allATMs;
    }

    @Override
    public Optional<ATM> saveAll(String name, String address, String city) {
        return Optional.of(this.atmRepository.save(new ATM(name,address,city)));
    }

    @Override
    public Optional<ATM> findById(Long id) {
        return atmRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        atmRepository.deleteById(id);
    }


}
