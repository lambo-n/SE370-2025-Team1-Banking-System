package com.se370group1.banking_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

  @GetMapping("/")
  public String home() {
    return "home";
  }
}