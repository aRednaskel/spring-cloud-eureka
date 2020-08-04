package com.spring.bankApp.domain.card;

import com.spring.bankApp.domain.model.card.Card;

public interface CardRetrieval {

    Card getByLastFourDigits(String lastFourDigits);
}
