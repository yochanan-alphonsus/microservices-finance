package com.nexus.transactions.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nexus.transactions.utils.EnumTransaction;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDTO {

    private String id;

    private Double amount;

    private EnumTransaction type;

    @NotEmpty(message = "Transaction description shouldn't be neither null nor empty")
    private String description;

    private LocalDate date;

    private String userId;

    private String categoryId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
