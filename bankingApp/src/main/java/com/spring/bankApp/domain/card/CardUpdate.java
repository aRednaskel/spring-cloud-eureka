package com.spring.bankApp.domain.card;

import com.spring.bankApp.domain.model.card.CardStatus;

public interface CardUpdate {

    void changeCardStatus(String lastFourDigits, CardStatus cardStatus);
}
