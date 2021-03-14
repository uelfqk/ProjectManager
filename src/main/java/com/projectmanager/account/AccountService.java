package com.projectmanager.account;

import com.projectmanager.account.form.SignUpForm;
import com.projectmanager.domain.Account;
import com.projectmanager.enums.AccountAuthority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account joinedNewAccount(SignUpForm signUpForm) {
        Account account = Account.createAccount(signUpForm.getUsername(),
                                                passwordEncoder.encode(signUpForm.getPassword()),
                                                AccountAuthority.ROLE_GUEST);
        return accountRepository.save(account);
    }

    public void signIn(Account account) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                new UserAccount(account),
                account.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority(account.getAuthority().getAuthority())));

        SecurityContextHolder.getContext().setAuthentication(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new UserAccount(account);
    }
}
