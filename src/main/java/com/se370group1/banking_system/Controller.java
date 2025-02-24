package com.se370group1.banking_system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller {

  @GetMapping("/home")
  public String home() {
    return "home";
  }
}