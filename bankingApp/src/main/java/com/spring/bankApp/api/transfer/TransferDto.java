package com.spring.bankApp.api.transfer;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Builder
@Value
public class TransferDto {

    @NotBlank
    @Size(min = 16, max = 16)
    private String fromAccountNumber;

    @NotBlank
    @Size(min = 16, max = 16)
    private String toAccountNumber;

    @Min(0)
    private BigDecimal amount;
}
