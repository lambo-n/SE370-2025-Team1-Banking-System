package com.se370group1.banking_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingSystemController {

  @GetMapping("/BankingSystemWebApp")
  public String sayHello() {
    return "This is our banking system web app";
  }
}