package com.spring.bankApp.domain.account;

import com.spring.bankApp.domain.model.account.Account;
public interface AccountRetrievalClient {

    Account findByAccountNumber(String accountNumber);

    Account findByAccountId(long id);

    Account findByAccNumberOrExtAccount(String accountNumber);


}
