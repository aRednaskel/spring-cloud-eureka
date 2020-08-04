package com.spring.bankApp.infrastructure.transfer;

import com.spring.bankApp.domain.model.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
