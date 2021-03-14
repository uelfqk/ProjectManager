package com.projectmanager.account;

import com.projectmanager.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUserId(String userId);

    Optional<Account> findByUserId(String userId);
}
