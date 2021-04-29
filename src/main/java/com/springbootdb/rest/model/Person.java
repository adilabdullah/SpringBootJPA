package com.springbootdb.rest.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
String name,dob;
double salary;
int age;



@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", age=" + age + "]";
}
public Person(int id, String name, String dob, double salary, int age) {
	super();
	this.id = id;
	this.name = name;
	this.dob = dob;
	this.salary = salary;
	this.age = age;
}
public Person() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}


}
