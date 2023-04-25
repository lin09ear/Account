package com.example.Account.service;

import com.example.Account.domain.Account;
import com.example.Account.domain.AccountStatus;
import com.example.Account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private String noFinal;

    @Transactional
    public void createAccount() {
        Account account = Account.builder()
                        .accountNumber("40000")
                        .accountStatus(AccountStatus.IN_USE)
                        .build();
        accountRepository.save(account);
    }

    @Transactional
    public Account getAccount(Long id) {
        if (id < 0) {
            throw new RuntimeException("Minus");
        }

        return accountRepository.findById(id).get();
    }

}
