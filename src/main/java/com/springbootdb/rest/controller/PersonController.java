package com.springbootdb.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdb.rest.model.Person;
import com.springbootdb.rest.service.PersonService;



@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
//	@RequestMapping(value="/Persons",method=RequestMethod.GET)
	@GetMapping("/persons")
	@ResponseBody
	public ResponseEntity<List<Person>> getAllPersons()
	{
	//	return this.PersonService.getAllPersons();
     List<Person> bok=this.personService.getAllPersons();
     if(bok.size()<=0)
     {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
     }
     return ResponseEntity.of(Optional.of(bok));
     
	}
	
	
	@GetMapping("/Person/{id}")
	@ResponseBody
	public ResponseEntity<Person> getSpecificPerson(@PathVariable("id") int id)
	{
		//return this.PersonService.getSpecificPerson(id);
		Person bok=this.personService.getSpecificPerson(id);
        if(bok==null)
        {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
      return ResponseEntity.of(Optional.of(bok));

	}
	
	@PostMapping("/AddPerson")
	@ResponseBody
	public ResponseEntity<Person> AddPerson(@RequestBody Person Person)
	{
		//return this.PersonService.AddPerson(Person);
		Person bkk=this.personService.AddPerson(Person);
		try {
			return ResponseEntity.of(Optional.of(bkk));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@DeleteMapping("/DeletePerson/{id}")
	@ResponseBody
	public String DeletePerson(@PathVariable int id)
	{
		this.personService.DeletePerson(id);
		return "Person deleted succesfully"; 
	/*	if(this.personService.DeletePerson(id)==1)
		{
			return "Person deleted succesfully";
		}
		else
		{
			return "Person does not found";
		}  */

	}
	
	
	@PutMapping("/UpdatePerson/{id}")
	@ResponseBody
	public ResponseEntity<Person> UpdatePerson(@RequestBody Person Person,@PathVariable int id)
	{
		//return this.PersonService.UpdatePerson(Person,id);
	try {
		return ResponseEntity.ok().body(this.personService.UpdatePerson(Person,id));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	
}
