package com.se370group1.banking_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController {

  @GetMapping("/home")
  public String sayHello() {
    return "home";
  }
}