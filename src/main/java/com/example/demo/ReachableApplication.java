package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.datapopulate.PopulateEntries;

@SpringBootApplication
public class ReachableApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReachableApplication.class, args);
		ReachableApplication.invokePopulateEntries();
	}
	
	public static void invokePopulateEntries() {
		PopulateEntries pEntries = new PopulateEntries();
		pEntries.populateEntries();
	}

}
