package com.infotech.people.management.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.people.management.app.dao.PeopleManagementDao;
import com.infotech.people.management.app.entities.Person;

@Service
public class PeopleManagementService 
{

	@Autowired
	PeopleManagementDao peopleManagementDao;

	public CompletableFuture<Person> findByEmail(String email) 
	{
		return peopleManagementDao.findByEmail(email);
	}

}
