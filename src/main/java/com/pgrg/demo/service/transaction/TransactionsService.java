package com.pgrg.demo.service.transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pgrg.demo.model.TransactionsUserDto;

public interface TransactionsService {

    public TransactionsUserDto createTransaction(Integer userId, String transactionType, Float amount) throws JsonProcessingException;

}
