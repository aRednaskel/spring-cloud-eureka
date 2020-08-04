package com.auction.auctionApp.domain.model.auction;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "auctions")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
@Getter
@Setter
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long accountId;
    private String accountNumber;
    private String title;
    private long itemsCount;
    private BigDecimal costOfAnItem;

    public static Auction createAuction(long accountId, String accountNumber, String title, long itemsCount, BigDecimal costOfAnItem) {
        return Auction.builder()
                .accountId(accountId)
                .accountNumber(accountNumber)
                .title(title)
                .itemsCount(itemsCount)
                .costOfAnItem(costOfAnItem).build();
    }

}
