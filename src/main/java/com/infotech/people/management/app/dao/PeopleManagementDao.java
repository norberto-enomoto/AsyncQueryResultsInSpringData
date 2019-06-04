package com.infotech.people.management.app.dao;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.infotech.people.management.app.entities.Person;

@Repository
public interface PeopleManagementDao extends CrudRepository<Person, Integer> 
{
	@Async	//it will execute this method in seperate Thread
	CompletableFuture<Person> findByEmail(String email);
	
}
