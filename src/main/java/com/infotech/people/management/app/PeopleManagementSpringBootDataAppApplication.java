package com.infotech.people.management.app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.infotech.people.management.app.entities.Person;
import com.infotech.people.management.app.service.PeopleManagementService;

@SpringBootApplication
@EnableAsync	//it enables Async annotation in DAO layer
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner
{

	@Autowired
	private PeopleManagementService peopleManagementService;
	
	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		CompletableFuture<Person> completableFuture = peopleManagementService.findByEmail("mohit@gmail.com");
		Person person = completableFuture.get(20, TimeUnit.SECONDS);
		System.out.println(person);
	}

}
