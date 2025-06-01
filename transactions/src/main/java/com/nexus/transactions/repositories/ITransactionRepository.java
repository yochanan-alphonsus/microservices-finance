package com.nexus.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nexus.transactions.entities.TransactionEntity;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, String> {
    @Query(value = "SELECT * FROM transactions_tbl as t WHERE LOWER(t.transaction_description) LIKE LOWER(CONCAT('%', :description, '%')) ORDER BY t.transaction_description ASC LIMIT 50", nativeQuery = true)
    public List<TransactionEntity> filterTransactions(@Param("description") String description);
}
