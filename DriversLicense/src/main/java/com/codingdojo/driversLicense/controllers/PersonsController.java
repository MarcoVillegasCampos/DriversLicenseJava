package com.codingdojo.driversLicense.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.driversLicense.models.Person;
import com.codingdojo.driversLicense.services.PersonService;



@Controller
public class PersonsController {
	
	private final PersonService personService;
    
    public PersonsController (PersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping("/persons")
    public String index(Model model,@ModelAttribute("form") Person languages) {
    
        return "newPerson.jsp";
    }
    
	
	
	
	   @RequestMapping(value="/persons/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("form") Person person, BindingResult result) {
	        if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            personService.createPerson(person);
	            return "redirect:/persons";
	        }
	    }
	   
	   @RequestMapping("/show/{id}")
	   public String show(@PathVariable("id") Long id, Model model) {
		   model.addAttribute("person", personService.findPerson(id));
		   return "showLicense.jsp";
		   
		   
	   }
	   

}
