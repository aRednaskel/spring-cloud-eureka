package com.spring.bankApp.domain.transfer;

import com.spring.bankApp.api.transfer.TransferDto;
import com.spring.bankApp.domain.model.transfer.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferFacade {

    private final TransferCreator transferCreator;
    private final TransferRetrieval transferRetrieval;

    public List<Transfer> findAllTransfers() {
        return transferRetrieval.findAll();
    }

    public void createTransfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        transferCreator.create(fromAccountNumber,toAccountNumber, amount);
    }


    public void createMultipleTransfersWithNumbers(List<TransferDto> transferList) {
        transferCreator.createMultipleTransfersWithNumbers(transferList);
    }

    public void multipleTransfersWithIds(List<TransferCommand> transferCommands) {
        transferCreator.createTransfersWithIds(transferCommands);
    }


}
