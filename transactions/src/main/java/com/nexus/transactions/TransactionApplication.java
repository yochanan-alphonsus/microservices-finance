package com.nexus.transactions;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.nexus.transactions.entities.TransactionEntity;
import com.nexus.transactions.repositories.ITransactionRepository;
import com.nexus.transactions.utils.EnumTransaction;

@EnableDiscoveryClient
@EnableJpaAuditing
@Configuration
@SpringBootApplication
public class TransactionApplication {

        public static void main(String[] args) {
                SpringApplication.run(TransactionApplication.class, args);
        }

        @Bean
        CommandLineRunner initDatabase(ITransactionRepository transactionRepository) {
                return args -> {
                        transactionRepository
                                        .save(TransactionEntity.builder().amount(600.00D)
                                                        .categoryId("0p9o8i7u6y-5t4r3e2w1q-p0o9i8u7y6")
                                                        .date(LocalDate.now()).description("Money spent on groceries")
                                                        .type(
                                                                        EnumTransaction.EXPENSE)
                                                        .userId("1q2w3e4r5t-6y7u8i9o0p-p0o9i8u7y6").build());

                        transactionRepository
                                        .save(TransactionEntity.builder().amount(1200.00D)
                                                        .categoryId("1q2w3e4r5t-6y7u8i9o0p-p0o9i8u7y6")
                                                        .date(LocalDate.now()).description("My Salary").type(
                                                                        EnumTransaction.INCOME)
                                                        .userId("0p9o8i7u6y-5t4r3e2w1q-p0o9i8u7y6").build());
                };

        }

}
