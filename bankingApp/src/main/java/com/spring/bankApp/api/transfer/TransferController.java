package com.spring.bankApp.api.transfer;

import com.spring.bankApp.domain.model.transfer.Transfer;
import com.spring.bankApp.domain.transfer.TransferCommand;
import com.spring.bankApp.domain.transfer.TransferFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferFacade transferFacade;

    @GetMapping(path = "/all")
    public void findAllTransfers() {

    }

    @PostMapping(path = "/transfer")
    public void createTransfer(@RequestBody TransferDto transferDto) {
        transferFacade.createTransfer(transferDto.getFromAccountNumber(), transferDto.getToAccountNumber(), transferDto.getAmount());
    }

    @PostMapping(path = "/transfers")
    public void createMultipleTransfersWithNumbers(@RequestBody List<TransferDto> transferDtos) {
        transferFacade.createMultipleTransfersWithNumbers(transferDtos);
    }

    @PostMapping(path = "/transferswithid")
    public void createMultipleTransfersWithIds(@RequestBody List<TransferCommand> transfers) {
        transferFacade.multipleTransfersWithIds(transfers);
    }

    private static class TransferMapper {
        private static TransferDto mapToDto(Transfer transfer) {
            return TransferDto.builder()
                    .fromAccountNumber(transfer.getFromAccountNumber())
                    .toAccountNumber(transfer.getToAccountNumber())
                    .amount(transfer.getAmount()).build();
        }

        private static Iterable<TransferDto> mapIterableUsersToDto(List<Transfer> transfers) {
            List<TransferDto> dtoTransfers = transfers.stream().map(transfer -> mapToDto(transfer)).collect(Collectors.toList());
            return dtoTransfers;
        }
    }
}
