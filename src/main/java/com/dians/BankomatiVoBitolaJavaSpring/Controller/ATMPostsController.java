package com.dians.BankomatiVoBitolaJavaSpring.Controller;

import com.dians.BankomatiVoBitolaJavaSpring.Model.ATMPosts;
import com.dians.BankomatiVoBitolaJavaSpring.Service.ATMPostsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class ATMPostsController {

   private final ATMPostsService atmPostsService;

    public ATMPostsController(ATMPostsService atmPostsService) {
        this.atmPostsService = atmPostsService;
    }

    @GetMapping
    public List<ATMPosts> getAllPosts(){
        return  atmPostsService.getAllATMPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ATMPosts> findById(@PathVariable Long id){
        return this.atmPostsService.findById(id)
                .map(atmPosts -> ResponseEntity.ok().body(atmPosts))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("add")
    public ResponseEntity<ATMPosts> savePost(@RequestParam String content, @RequestParam String title,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publishDate){
        return atmPostsService.saveAtmPosts(title,content,publishDate)
                .map(atmPosts -> ResponseEntity.ok().body(atmPosts))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        atmPostsService.deleteById(id);
    }
}
