package com.practica.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthentificationController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        Account acc = accountRepository.findAccountByUsername(username);
        if(acc == null) return "false";
        if(acc.password.equals(password)){
            return "true";
        }else return "false";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password){
        if(accountRepository.findAccountByUsername(username) != null) return "false";
        accountRepository.save(new Account(username, password));
        return "true";
    }

}