package com.spring.bankApp.infrastructure.transfer;


import com.spring.bankApp.domain.model.transfer.Transfer;
import com.spring.bankApp.domain.transfer.TransferRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferPostgressRetrieval implements TransferRetrieval {

    private final TransferRepository transferRepository;

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }
}
