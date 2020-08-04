package com.spring.bankApp.domain.account;

public interface AccountCreator {

    void createPremiumToUser(long userId);

    void createStandardToUser(long userId);
}
