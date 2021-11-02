package com.codingdojo.driversLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.driversLicense.models.Person;


	
	
	
	public interface PersonRepository extends CrudRepository<Person, Long> {
		List<Person> findAll();
		List<Person> findByLicenseIdIsNull();
	}


