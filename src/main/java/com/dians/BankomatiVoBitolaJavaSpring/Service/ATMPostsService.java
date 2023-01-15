package com.dians.BankomatiVoBitolaJavaSpring.Service;

import com.dians.BankomatiVoBitolaJavaSpring.Model.ATMPosts;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface ATMPostsService {
    List<ATMPosts> getAllATMPosts();
    Optional<ATMPosts> findById(Long id);
    void deleteById(Long id);
    Optional<ATMPosts> saveAtmPosts(String title,String content, LocalDate publish_date);
}
