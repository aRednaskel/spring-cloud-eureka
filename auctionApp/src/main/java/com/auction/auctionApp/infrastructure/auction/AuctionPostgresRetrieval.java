package com.auction.auctionApp.infrastructure.auction;

import com.auction.auctionApp.domain.auction.AuctionRetrieval;
import com.auction.auctionApp.domain.model.auction.Auction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class AuctionPostgresRetrieval implements AuctionRetrieval {

    private final AuctionRepository auctionRepository;

    @Override
    public List<Auction> getByAccountId(long accountId) {
        return auctionRepository.findAll().stream()
                .filter(auction -> auction.getAccountId() == accountId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }
}
