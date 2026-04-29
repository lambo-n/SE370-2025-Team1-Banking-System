package com.se370group1.banking_system.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.service.BankingFacadeService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final BankingFacadeService bankingFacadeService;

    public UserController(BankingFacadeService bankingFacadeService) {
        this.bankingFacadeService = bankingFacadeService;
    }

    @GetMapping("/logInUser")
    public Boolean logInUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        return bankingFacadeService.logInUser(username, password, session);
    }

    @GetMapping("/createNewUser")
    public void createNewUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam int phoneNum,
            @RequestParam int socialSecurityNum,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String state,
            @RequestParam String zip) {

        bankingFacadeService.createNewUser(
                username,
                password,
                firstName,
                lastName,
                email,
                phoneNum,
                socialSecurityNum,
                street,
                city,
                state,
                zip
        );
    }

    @GetMapping("/logOutUser")
    public void logOutUser(HttpSession session) {
        bankingFacadeService.logOutUser(session);
    }

    @GetMapping("/sessionStatus")
    public Map<String, Object> sessionStatus(HttpSession session) {
        return bankingFacadeService.sessionStatus(session);
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        return bankingFacadeService.dashboard(session);
    }
}