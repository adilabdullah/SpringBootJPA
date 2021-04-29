package com.springbootdb.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbootdb.rest.dao.PersonsRepository;
import com.springbootdb.rest.model.Person;


@Component
public class PersonService {

	@Autowired
	PersonsRepository personRepository;
	
	public List<Person> getAllPersons()
	{
		List<Person> lis=(List<Person>)this.personRepository.findAll();
		return lis;
	}
	
	public Person getSpecificPerson(int id)
	{
	   return this.personRepository.findById(id);

	//	return bok;
	}
	
	public Person AddPerson(Person bk)
	{
 return this.personRepository.save(bk);
 
	}
	
	public void DeletePerson(int id)
	{
		this.personRepository.deleteById(id);
	}
			
	public Person UpdatePerson(Person bok,int id)
	{
	  bok.setId(id);
	  return this.personRepository.save(bok);
	}
			

	
}
