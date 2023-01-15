package com.dians.BankomatiVoBitolaJavaSpring.Controller;

import com.dians.BankomatiVoBitolaJavaSpring.Model.ATM;
import com.dians.BankomatiVoBitolaJavaSpring.Service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ATMController {

    private final ATMService atmService;

    @Autowired
    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/getATM")
    public List<ATM> getAll() {
        List<ATM> getAllList = atmService.getAllAtm();
        return getAllList;
    }

    @PostMapping("/add")
    public ResponseEntity<ATM> save(@RequestParam String name,
                                    @RequestParam String address,
                                    @RequestParam String city) {
        return this.atmService.saveAll(name, address, city)
                .map(atm -> ResponseEntity.ok().body(atm))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ATM> findById(@PathVariable Long id) {
        return this.atmService.findById(id)
                .map(atm -> ResponseEntity.ok().body(atm))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         atmService.deleteById(id);
    }
}
