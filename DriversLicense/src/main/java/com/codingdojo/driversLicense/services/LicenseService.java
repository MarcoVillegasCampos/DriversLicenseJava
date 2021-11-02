package com.codingdojo.driversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driversLicense.models.License;
import com.codingdojo.driversLicense.repositories.LicenseRepository;


@Service
public class LicenseService {

	

	 // adding the license repository as a dependency
   private final LicenseRepository licenseRepository;
   
   public LicenseService(LicenseRepository licenseRepository) {
       this.licenseRepository = licenseRepository;
   }
   // returns all the license
   public List<License> allLicenses() {
       return licenseRepository.findAll();
   }
   // creates a license
   public License createLicense(License l) {
	   l.setNumber(l.getNumber()+1);
       return licenseRepository.save(l);
   }
   // retrieves a license
   public License findLicense(Long id) {
       Optional<License> optionalLicense = licenseRepository.findById(id);
       if(optionalLicense.isPresent()) {
           return optionalLicense.get();
       } else {
           return null;
       }
   }
   // deletes a license
   
   public void deleteLicense(Long id) {
   licenseRepository.deleteById(id);
   	}
   
	public int generateLicenseNumber() {
		License l = licenseRepository.findTopByOrderByNumberDesc();
		if(l == null)
			return 0;
		int largestNumber = l.getNumber();
		
		return (largestNumber);
	}
   
   	
   	
  
   
   //updates a license
   

  
  public License updatePerson(License license) {
		 License updatedLicense=new License();
		 
		 
		 updatedLicense.setId(license.getId());
		 updatedLicense.setNumber(license.getNumber());
		 updatedLicense.setExpirationDate(license.getExpirationDate());
		 updatedLicense.setState(license.getState());
		 
		
	
		
		 
		 
		 
		licenseRepository.save(license);
		 
		 return license;
		 
	   }
}
