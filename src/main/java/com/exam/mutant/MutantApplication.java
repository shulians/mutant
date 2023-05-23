package com.exam.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MutantApplication {

	public static void main(String[] args) {SpringApplication.run(MutantApplication.class, args);}

}

