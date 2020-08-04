package com.auction.auctionApp.infrastructure.auction;

import com.auction.auctionApp.domain.auction.AuctionDeleter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuctionPostgresDeleter implements AuctionDeleter {

    private final AuctionRepository auctionRepository;

    @Override
    public void deleteAuctionById(long auctionId) {
        auctionRepository.deleteById(auctionId);
    }
}
