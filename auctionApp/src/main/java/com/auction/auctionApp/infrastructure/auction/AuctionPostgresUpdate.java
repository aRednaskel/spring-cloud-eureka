package com.auction.auctionApp.infrastructure.auction;

import com.auction.auctionApp.domain.auction.AuctionUpdate;
import com.auction.auctionApp.domain.model.auction.Auction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
class AuctionPostgresUpdate implements AuctionUpdate {

    private final AuctionRepository auctionRepository;

    @Override
    @Transactional
    public void changeTitle(long auctionId, String title) {
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        auction.setTitle(title);
    }

    @Override
    @Transactional
    public void changeCostOfItem(long auctionId, BigDecimal costOfItem) {
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        auction.setCostOfAnItem(costOfItem);
    }
}
