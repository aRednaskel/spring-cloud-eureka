package com.spring.bankApp.infrastructure.account;

import com.spring.bankApp.domain.account.AccountRetrievalClient;
import com.spring.bankApp.domain.model.account.Account;
import com.spring.bankApp.domain.model.account.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
class AccountRetrievalPostgresClient implements AccountRetrievalClient {

    private final AccountRepository accountRepository;

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Account findByAccountId(long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Account findByAccNumberOrExtAccount(String accountNumber) {
        Account externalAccount = Account.builder()
                .accountNumber(accountNumber)
                .accountType(AccountType.EXTERNAL)
                .balance(BigDecimal.ZERO)
                .build();
        return accountRepository.findByAccountNumber(accountNumber)
                .orElse(externalAccount);
    }
}
