package com.projectmanager.account.validator;

import com.projectmanager.account.AccountRepository;
import com.projectmanager.account.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(SignUpForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpForm signUpForm = (SignUpForm)target;

        if(isNotValidDuplicateUserId(signUpForm.getUsername())) {
            errors.rejectValue("account", "wrong.account", "이미 사용중인 아이디 입니다.");
        }

        if(isNotValidPasswordConfirm(signUpForm.getPassword(), signUpForm.getPasswordConfirm())) {
            errors.rejectValue("password", "wrong.password", "비밀번호가 일치하지 않습니다.");
        }
    }

    private boolean isNotValidDuplicateUserId(String username) {
        return !accountRepository.existsByUsername(username);
    }

    private boolean isNotValidPasswordConfirm(String password, String passwordConfirm) {
        return !password.equals(passwordConfirm);
    }
}
