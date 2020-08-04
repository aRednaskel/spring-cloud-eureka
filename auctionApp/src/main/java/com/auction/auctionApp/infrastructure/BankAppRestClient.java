package com.auction.auctionApp.infrastructure;

import com.auction.auctionApp.api.order.OrderDto;
import com.auction.auctionApp.domain.BankAppClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class BankAppRestClient implements BankAppClient {

    private final String bankAppHost;
    private final String makeTransactionUri;
    private final RestTemplate restTemplate;

    public BankAppRestClient(@Value("${bank.app.host}") String bankAppHost,
                             @Value("${executeTransactions.uri}") String makeTransactionUri,
                             RestTemplate restTemplate) {
        this.bankAppHost = bankAppHost;
        this.makeTransactionUri = makeTransactionUri;
        this.restTemplate = restTemplate;
    }

    @Override
    public void execute(OrderDto orderDto) {
        String url = bankAppHost + makeTransactionUri;
        HttpEntity<OrderDto> requestEntity = new HttpEntity<>(orderDto);
        try {
            restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    Void.class
            );
        } catch (HttpStatusCodeException exception) {
            throw new ResponseStatusException(exception.getStatusCode(), exception.getMessage());
        }
    }
}
