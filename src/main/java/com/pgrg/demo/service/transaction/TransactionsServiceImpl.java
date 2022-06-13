package com.pgrg.demo.service.transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pgrg.demo.config.Sender;
import com.pgrg.demo.constants.KafkaTopicTopics;
import com.pgrg.demo.model.Transactions;
import com.pgrg.demo.model.TransactionsUserDto;
import com.pgrg.demo.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private Sender sender;
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public TransactionsUserDto createTransaction(Integer userId, String transactionType, Float amount) throws JsonProcessingException {
        Transactions tx = new Transactions(transactionType, amount, userId);
        tx = transactionRepo.save(tx);
        sender.send(tx, KafkaTopicTopics.CREDIT_SCORE_CALCULATE);
        TransactionsUserDto txDto = new TransactionsUserDto();
        return null;
    }


}
