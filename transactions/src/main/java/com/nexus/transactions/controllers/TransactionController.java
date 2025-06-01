package com.nexus.transactions.controllers;

import com.nexus.transactions.entities.TransactionEntity;
import com.nexus.transactions.services.TransactionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<String> createTransaction(@Valid @RequestBody TransactionEntity transaction) {
        this.transactionService.createTransaction(transaction);
        return new ResponseEntity<String>("Transaction Created Successfully", null, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<TransactionEntity>> readTransactionById(@PathVariable String id) {
        Optional<TransactionEntity> transactionFound = this.transactionService.readTransactionById(id);
        return new ResponseEntity<Optional<TransactionEntity>>(transactionFound, null, HttpStatus.FOUND);
    }

    @GetMapping(params = "description")
    public ResponseEntity<List<TransactionEntity>> filterTransactions(
            @RequestParam String description) {
        List<TransactionEntity> transactionsFound = this.transactionService.filterTransactions(
                description);

        return new ResponseEntity<List<TransactionEntity>>(transactionsFound, null, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<TransactionEntity>> readAllTransactions() {
        List<TransactionEntity> transactions = this.transactionService.readAllTransactions();

        return new ResponseEntity<List<TransactionEntity>>(transactions, null, HttpStatus.FOUND);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> updateTransaction(@PathVariable String id,
            @Valid @RequestBody TransactionEntity transaction) {
        this.transactionService.updateTransaction(id, transaction);
        return new ResponseEntity<String>("Transaction Updated Successfully", null, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable String id) {
        this.transactionService.deleteTransaction(id);
        return new ResponseEntity<String>("Transaction deleted successfully", null, HttpStatus.OK);
    }

}
