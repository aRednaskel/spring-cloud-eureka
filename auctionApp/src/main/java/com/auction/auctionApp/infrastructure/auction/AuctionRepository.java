package com.auction.auctionApp.infrastructure.auction;

import com.auction.auctionApp.domain.model.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

interface AuctionRepository extends JpaRepository<Auction, Long> {

}
