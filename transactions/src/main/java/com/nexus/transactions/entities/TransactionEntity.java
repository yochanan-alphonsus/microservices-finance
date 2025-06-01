package com.nexus.transactions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nexus.transactions.utils.EnumTransaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "transactions_tbl")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transaction_id", unique = true, nullable = false)
    private String id;

    @Column(name = "transaction_amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_type", nullable = false)
    private EnumTransaction type;

    @Column(name = "transaction_description", nullable = false)
    private String description;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate date;

    @Column(name = "transaction_user_id", nullable = false)
    private String userId;

    @Column(name = "transaction_category_id", nullable = false)
    private String categoryId;

    @CreatedDate
    @Column(name = "transaction_created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "transaction_updated_at", updatable = true, nullable = false)
    private LocalDateTime updatedAt;
}
