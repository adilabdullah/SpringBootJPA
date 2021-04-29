package com.springbootdb.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.springbootdb.rest.model.Person;

public interface PersonsRepository extends CrudRepository<Person,Integer>{
	
public Person findById(int id);
}
