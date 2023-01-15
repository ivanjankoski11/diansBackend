package com.dians.BankomatiVoBitolaJavaSpring.Service.impl;

import com.dians.BankomatiVoBitolaJavaSpring.Model.ATM;
import com.dians.BankomatiVoBitolaJavaSpring.Model.ATMPosts;
import com.dians.BankomatiVoBitolaJavaSpring.Repository.ATMPostRepository;
import com.dians.BankomatiVoBitolaJavaSpring.Service.ATMPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ATMPostsServiceImpl implements ATMPostsService {

    public final ATMPostRepository atmPostRepository;


    public ATMPostsServiceImpl(ATMPostRepository atmPostRepository) {
        this.atmPostRepository = atmPostRepository;
    }

    @Override
    public List<ATMPosts> getAllATMPosts() {
        List<ATMPosts> allAtmPosts = atmPostRepository.findAll();
        return allAtmPosts;
    }

    @Override
    public Optional<ATMPosts> findById(Long id) {
            return atmPostRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
     this.atmPostRepository.deleteById(id);

    }

    @Override
    public Optional<ATMPosts> saveAtmPosts(String title, String content, LocalDate publish_date) {
        return Optional.of(atmPostRepository.save(new ATMPosts(title,content,publish_date)));
    }

}
