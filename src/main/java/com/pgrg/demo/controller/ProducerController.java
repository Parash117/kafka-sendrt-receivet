package com.pgrg.demo.controller;

import com.pgrg.demo.config.Sender;
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


    @GetMapping("/message/{msg}")
    public void produceTestMsg(@PathVariable("msg") String msg){
        sender.send(msg);
    }
}
