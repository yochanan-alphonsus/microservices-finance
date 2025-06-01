package com.nexus.transactions.services;

import com.nexus.transactions.entities.TransactionEntity;
import com.nexus.transactions.repositories.ITransactionRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final ITransactionRepository transactionRepository;

    public void createTransaction(TransactionEntity transaction) {
        try {
            this.transactionRepository.save(
                    TransactionEntity.builder()
                            .amount(transaction.getAmount())
                            .description(transaction.getDescription())
                            .type(transaction.getType())
                            .date(transaction.getDate() == null ? LocalDate.now() : transaction.getDate())
                            .userId(transaction.getUserId())
                            .categoryId(transaction.getCategoryId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<TransactionEntity> readTransactionById(String id) {
        try {
            return this.transactionRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TransactionEntity> filterTransactions(String description) {
        try {
            return this.transactionRepository.filterTransactions(description);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TransactionEntity> readAllTransactions() {
        try {
            return this.transactionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTransaction(String id, TransactionEntity transaction) {
        try {
            TransactionEntity transactionFound = this.transactionRepository.findById(id).orElse(null);
            assert transactionFound != null;
            transactionFound
                    .setAmount(
                            transaction.getAmount() == null ? transactionFound.getAmount() : transaction.getAmount());
            transactionFound
                    .setCategoryId(transaction.getCategoryId() == null ? transactionFound.getCategoryId()
                            : transaction.getCategoryId());
            transactionFound.setDate(
                    transaction.getDate() == null ? transactionFound.getDate() : transaction.getDate());
            transactionFound.setDescription(transaction.getDescription() == null ? transactionFound.getDescription()
                    : transaction.getDescription());
            transactionFound.setType(transaction.getType() == null ? transactionFound.getType()
                    : transaction.getType());
            transactionFound.setUserId(transaction.getUserId() == null ? transactionFound.getUserId()
                    : transaction.getUserId());

            this.transactionRepository.save(transactionFound);
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }

    public void deleteTransaction(String id) {
        try {
            this.transactionRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
