package com.dians.BankomatiVoBitolaJavaSpring.Repository;

import com.dians.BankomatiVoBitolaJavaSpring.Model.ATMPosts;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATMPostRepository extends JpaRepository<ATMPosts, Long> {
}
