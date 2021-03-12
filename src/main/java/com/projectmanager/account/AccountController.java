package com.projectmanager.account;

import com.projectmanager.account.form.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/sign-up")
    public String createSignupForm(Model model) {
        model.addAttribute("signUpForm", new SignupForm());
        return "account/sign-up";
    }
}
