package com.pgrg.demo.repo;

import com.pgrg.demo.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepo extends JpaRepository<CreditScore, Integer> {

    @Query(nativeQuery=true, value= "select * from credit_score where user_id = ?1")
    CreditScore getByUserId(Integer userId);
}
