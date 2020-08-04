package com.spring.bankApp.infrastructure.account;

import com.spring.bankApp.domain.account.AccountCreator;
import com.spring.bankApp.domain.model.account.Account;
import com.spring.bankApp.domain.model.account.AccountType;
import com.spring.bankApp.domain.model.user.User;
import com.spring.bankApp.domain.user.UserRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
class AccountCreatorImpl implements AccountCreator {

    private final UserRetrieval userRetrieval;

    @Transactional
    @Override
    public void createPremiumToUser(long userId) {
        User user = userRetrieval.getById(userId);
        user.addAccount(Account.builder()
                .accountNumber(UUID.randomUUID().toString().substring(1,17))
                .balance(BigDecimal.valueOf(10000000l))
                .accountType(AccountType.PREMIUM).build());
    }

    @Transactional
    @Override
    public void createStandardToUser(long userId) {
        User user = userRetrieval.getById(userId);
        user.addAccount(Account.builder()
                .accountNumber(UUID.randomUUID().toString().substring(1,17))
                .balance(BigDecimal.ZERO)
                .accountType(AccountType.PREMIUM).build());
    }


}
