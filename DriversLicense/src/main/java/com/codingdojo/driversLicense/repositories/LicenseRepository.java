package com.codingdojo.driversLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.driversLicense.models.License;



public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
	public License findTopByOrderByNumberDesc();
}


