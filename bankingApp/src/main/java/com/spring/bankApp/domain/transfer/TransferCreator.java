package com.spring.bankApp.domain.transfer;

import com.spring.bankApp.api.transfer.TransferDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransferCreator {

    void create(String fromAccountNumber, String toAccountNumber, BigDecimal amount);

    void createMultipleTransfersWithNumbers(List<TransferDto> transfers);

    void createTransfersWithIds(List<TransferCommand> transfers);
}
