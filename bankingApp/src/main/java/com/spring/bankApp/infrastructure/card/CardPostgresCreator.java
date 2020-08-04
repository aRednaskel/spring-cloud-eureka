package com.spring.bankApp.infrastructure.card;

import com.spring.bankApp.domain.account.AccountRetrievalClient;
import com.spring.bankApp.domain.card.CardCreator;
import com.spring.bankApp.domain.model.account.Account;
import com.spring.bankApp.domain.model.card.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@RequiredArgsConstructor
class CardPostgresCreator implements CardCreator {

    private final AccountRetrievalClient accountRetrievalClient;

    @Override
    @Transactional
    public void create(String accountNumber) {
        Account account = accountRetrievalClient.findByAccountNumber(accountNumber);
        Random random = new Random();
        String randomNumber = ("000" + random.nextInt() * 10000);
        randomNumber = randomNumber.substring((randomNumber.length()-4));
        account.addCard(Card.createCard(randomNumber));
    }
}
