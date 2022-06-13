package com.pgrg.demo.repo;

import com.pgrg.demo.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepo extends JpaRepository<Transactions, Integer> {
}
