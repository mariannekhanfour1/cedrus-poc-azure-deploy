package com.tutorial.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

import java.text.NumberFormat;
import java.util.Locale;

@SpringBootApplication
public class Application {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}




	//add my own bean
	@Bean // adding the bean to application context
	public NumberFormat defaultCurrencyFormat(){
		return NumberFormat.getCurrencyInstance();
	}

	@Bean
	public NumberFormat GermanCurrencyFormat(){
		System.out.println("################### bean 2");
		return NumberFormat.getCurrencyInstance(Locale.GERMAN);
	}

}
