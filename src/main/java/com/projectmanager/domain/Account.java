package com.projectmanager.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "account")
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String authority;

    public static Account createAccount(String username, String password, String authority) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setAuthority(authority);
        return account;
    }
}
