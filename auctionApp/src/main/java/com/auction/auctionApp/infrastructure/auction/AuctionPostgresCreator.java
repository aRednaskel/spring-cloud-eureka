package com.auction.auctionApp.infrastructure.auction;

import com.auction.auctionApp.domain.auction.AuctionCreator;
import com.auction.auctionApp.domain.model.auction.Auction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
class AuctionPostgresCreator implements AuctionCreator {

    private final AuctionRepository auctionRepository;

    @Override
    public void create(long accountId, String accountNumber, String title,  long itemsCount, BigDecimal costOfAnItem) {
        Auction auction = Auction.createAuction(accountId, accountNumber, title, itemsCount, costOfAnItem);
        auctionRepository.save(auction);
    }
}
