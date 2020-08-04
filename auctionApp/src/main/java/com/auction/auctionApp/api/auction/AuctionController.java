package com.auction.auctionApp.api.auction;

import com.auction.auctionApp.domain.auction.AuctionFacade;
import com.auction.auctionApp.domain.model.auction.Auction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/auctions")
public class AuctionController {

    private final AuctionFacade auctionFacade;

    @PostMapping(path = "/create")
    public void createAuction(@RequestBody AuctionDto auction) {
        auctionFacade.createAuction(auction.getAccountId(), auction.getAccountNumber(),auction.getTitle(),auction.getItemsCount(),auction.getCostOfAnItem());
    }

    @GetMapping(path = "/{accountId}")
    public List<AuctionDto> findAuctionsWithAccountId(@PathVariable long accountId) {
        return AuctionMapper.mapAuctionListToDto(auctionFacade.findAuctionsWithAccountId(accountId));
    }

    @GetMapping(path = "/all")
    public List<AuctionDto> findAllAuctions() {
        return AuctionMapper.mapAuctionListToDto(auctionFacade.findAll());
    }

    @PatchMapping(path = "/{auctionId}")
    public void updateTitle(@PathVariable long auctionId, @RequestParam String title) {
        auctionFacade.updateTitle(auctionId, title);
    }

    @PatchMapping(path = "/{auctionId}/newprice")
    public void changePrice(@PathVariable long auctionId, @RequestParam BigDecimal price) {
        auctionFacade.changeCostOfItem(auctionId, price);
    }

    @DeleteMapping(path = "/delete/{auctionId}")
    public void deleteAuction(@PathVariable long auctionId) {
        auctionFacade.deleteAuctionById(auctionId);
    }



    private static class AuctionMapper {
        private static AuctionDto mapToDto(Auction auction) {
            return AuctionDto.builder()
                    .accountId(auction.getId())
                    .accountNumber(auction.getAccountNumber())
                    .title(auction.getTitle())
                    .costOfAnItem(auction.getCostOfAnItem())
                    .itemsCount(auction.getItemsCount()).build();
        }

        private static List<AuctionDto> mapAuctionListToDto(List<Auction> auctions) {
            List<AuctionDto> dtoAuctions = auctions.stream()
                    .map(AuctionMapper::mapToDto).collect(Collectors.toList());
            return dtoAuctions;
        }
    }

}
