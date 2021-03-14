package com.projectmanager.account;

import com.projectmanager.account.form.SignUpForm;
import com.projectmanager.account.validator.SignUpFormValidator;
import com.projectmanager.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    private final SignUpFormValidator signUpFormValidator;

    @InitBinder("singUpForm")
    public void signUpFormValidatorInit(WebDataBinder webDataBinder){
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/sign-up")
    public String createSignupForm(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "accounts/sign-up";
    }

    @PostMapping("/sign-up")
    public String submitSignUp(@Valid @ModelAttribute SignUpForm signUpForm, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "accounts/sign-up";
        }

        Account account = accountService.joinedNewAccount(signUpForm);
        accountService.signIn(account);
        return "redirect:/main-home";
    }
}
