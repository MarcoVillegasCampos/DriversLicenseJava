package com.codingdojo.driversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driversLicense.models.Person;
import com.codingdojo.driversLicense.repositories.PersonRepository;


@Service
public class PersonService {
	
	
	 // adding the person repository as a dependency
    private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // returns all the persons
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    // creates a person
    public Person createPerson(Person l) {
        return personRepository.save(l);
    }
    
	public List<Person> getUnlicensedPeople() {
		return personRepository.findByLicenseIdIsNull();
	}
    // retrieves a person
    public Person findPerson(Long id) {
        Optional<Person> optionalLanguage = personRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    // deletes a person
    
    public void deletePerson(Long id) {
    	personRepository.deleteById(id);
    	}
    
    	
    	
   
    
    //updates a person
    

   
   public Person updatePerson(Person person) {
		 Person updatedPerson=new Person();
		 
		 
		 updatedPerson.setId(person.getId());
		 updatedPerson.setFirstName(person.getFirstName());
		 updatedPerson.setLastName(person.getLastName());
	
		
		 
		 
		 
		personRepository.save(person);
		 
		 return person;
		 
	   }

}
