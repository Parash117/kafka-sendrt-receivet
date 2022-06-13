package com.pgrg.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pgrg.demo.config.Sender;
import com.pgrg.demo.service.transaction.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private Sender sender;

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/message/{msg}")
    public void produceTestMsg(@PathVariable("msg") String msg){
        sender.send(msg);
    }

    @GetMapping("/transaction/user-id/{userId}/transaction-type/{transactionType}/amount/{amount}")
    public void produceTx(@PathVariable("userId") Integer userId,
                          @PathVariable("transactionType") String transactionType,
                          @PathVariable("amount") Float amount) throws JsonProcessingException {
        transactionsService.createTransaction(userId, transactionType, amount);
    }
}
