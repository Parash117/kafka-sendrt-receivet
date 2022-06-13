package com.pgrg.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transactions {

    @Id
    @GeneratedValue
    private Integer id;

    private String transactionType;

    private Float amount;

    private Integer userId;

    public Transactions(String transactionType, Float amount, Integer userId) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.userId = userId;
    }
}
