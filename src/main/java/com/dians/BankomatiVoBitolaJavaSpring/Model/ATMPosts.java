package com.dians.BankomatiVoBitolaJavaSpring.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ATMPosts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate publishDate;

    public ATMPosts(String title, String content, LocalDate publishDate) {
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
    }
}

