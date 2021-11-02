package com.codingdojo.driversLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.driversLicense.models.License;
import com.codingdojo.driversLicense.models.Person;
import com.codingdojo.driversLicense.services.LicenseService;
import com.codingdojo.driversLicense.services.PersonService;

@Controller
public class LicensesController {
	
	private final LicenseService licenseService;
	private final PersonService personService;

    public LicensesController (LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService=personService;
    }
    
 
    
    @RequestMapping("/licenses")
	public String NewLicense(@ModelAttribute("form") License license, Model model) {
		List<Person> personList = personService.getUnlicensedPeople();
		
		model.addAttribute("persons", personList);
		return "newLicense.jsp";
	}
    
	
	
	
	   @RequestMapping(value="/licenses", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("form") License license,  BindingResult result) {
	        if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	        	license.setNumber(licenseService.generateLicenseNumber());
	            licenseService.createLicense(license);
	           
	            return "redirect:/licenses";
	        }
	    }

	
	
}
