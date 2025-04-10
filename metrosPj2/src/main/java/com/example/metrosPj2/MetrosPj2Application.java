package com.example.metrosPj2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling

public class MetrosPj2Application {

	public static void main(String[] args) {
		SpringApplication.run(MetrosPj2Application.class, args);
	}
//	@Scheduled(fixedRate = 3000)
//	public void starting(){
//		System.out.println("ishlashi har 1 sekubd"+new Date());
//	}

//	@Scheduled(initialDelay = 1000,fixedDelay = 2000)
//	public void scheduled() {
//		System.out.println("scheduled ishlaan");
//	}
	//initDelay kutib turadi boshida ishlaydi

//	@Scheduled(cron = "0 43 6 * * *")
//	public void startTim(){
//		System.out.println("ishlashi har 1 cronning"+new Date());
//	}



}
