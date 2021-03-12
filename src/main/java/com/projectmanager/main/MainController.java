package com.projectmanager.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String login() {
        return "sign-in";
    }

    @PostMapping("/login")
    public String submitLogin() {
        return "redirect:/";
    }
}
