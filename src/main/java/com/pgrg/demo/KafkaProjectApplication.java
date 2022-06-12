package com.pgrg.demo;

import com.pgrg.demo.config.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProjectApplication.class, args);
	}

	@Autowired
	private Sender sender;

	@Override
	public void run(String... strings) throws Exception {
		for (int i = 1; i < 11; i++){
			sender.send("Message-" + i);
		}
	}
}
