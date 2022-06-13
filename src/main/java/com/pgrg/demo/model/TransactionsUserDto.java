package com.pgrg.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsUserDto extends Users{

    private List<Transactions> transactionsList;

    public TransactionsUserDto(Users users, List<Transactions> tx){
        super(users);
        this.transactionsList = tx;
    }
}
