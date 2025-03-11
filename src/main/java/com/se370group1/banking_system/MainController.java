package com.se370group1.banking_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

  @GetMapping("/")
  public String redirectToHome() {
    return "redirect:/home";
  }

  @GetMapping("/home")
  public String home() {
    return "home";
  }

  @GetMapping("/signup")
  public String signup() {
    return "signup";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}