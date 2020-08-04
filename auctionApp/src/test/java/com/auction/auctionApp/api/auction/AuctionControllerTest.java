package com.auction.auctionApp.api.auction;

import com.auction.auctionApp.domain.auction.AuctionRetrieval;
import com.auction.auctionApp.domain.model.auction.Auction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuctionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuctionRetrieval auctionRetrieval;

    @Test
    public void createAuctionTest() throws Exception {
       mockMvc.perform(post("/v1/auctions/create")
                .content("{\"accountId\":1, \"accountNumber\":\"123456789\", \"title\":\"First auction\", \"itemsCount\":10, \"costOfAnItem\":5}")
                    .contentType(MediaType.APPLICATION_JSON));
        mockMvc.perform(post("/v1/auctions/create")
                .content("{\"accountId\":1, \"accountNumber\":\"87987321\", \"title\":\"Second auction\", \"itemsCount\":20, \"costOfAnItem\":15}")
                .contentType(MediaType.APPLICATION_JSON));
       ObjectMapper objectMapper = new ObjectMapper();
       List<Auction> auctions = auctionRetrieval.getByAccountId(1);
       Assert.assertTrue(auctions.size()==2);
    }

    @Test
    public void getAllAuctionTest() throws Exception {
       MvcResult mvcResult = mockMvc.perform(get("/v1/auctions/all"))
            .andReturn();
       Assert.assertTrue(mvcResult.getResponse().getStatus()==200);
    }



}
