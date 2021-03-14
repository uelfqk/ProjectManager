package com.projectmanager.account;

import com.projectmanager.domain.Account;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;

@Getter
public class UserAccount extends User {
    private Account account;

    public UserAccount(Account account) {
        // TODO 2021.03.14 현재 인증된 사용자 정보 참조
        //                 유저 도메인 객체의 정보를 스프링 시큐리티가 관리하는 유저 정보에 삽입
        super(account.getUsername(), account.getPassword(), Arrays.asList(new SimpleGrantedAuthority(account.getAuthority().getAuthority())));
        // TODO 2021.03.14 현재 인증된 사용자 정보 참조
        //                 @CurrentAccount 애노테이션을 사용하는 핸들러에서 인증된 사용자의 정보를 가져오기 위해
        //                 현재 참조중인 Account 를 account 에 삽입
        this.account = account;
    }
}
