package com.projectmanager.account;

import com.projectmanager.account.form.SignUpForm;
import com.projectmanager.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void joinedNewAccount(SignUpForm signUpForm) {
//        Account account = Account.createAccount(signUpForm.getUsername(), signUpForm.getPassword(), Account.getAuthority());
//        accountRepository.save(account);
    }
}
