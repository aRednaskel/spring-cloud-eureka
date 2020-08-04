package com.spring.bankApp.domain.transfer;

import com.spring.bankApp.domain.model.transfer.Transfer;

import java.util.List;

public interface TransferRetrieval {

    List<Transfer> findAll();
}
