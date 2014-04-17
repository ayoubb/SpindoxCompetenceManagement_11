package tn.spindox.server.model.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tn.spindox.shared.Employee;



@Entity
@Table
public class Person {
	
	private int id_pers;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String region;
	private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_pers() {
		return id_pers;
	}
	public void setId_pers(int id_pers) {
		this.id_pers = id_pers;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person( String firstName, String lastName,
			String birthDate, String region, String email) {
		super();
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.region = region;
		this.email = email;
	}
	
	public Person(){
		
	}
	public Person(Employee employee)
	{
		this.id_pers = employee.getId_pers();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.birthDate = employee.getBirthDate();
		this.region = employee.getRegion();
		this.email = employee.getEmail();
	}
	

	
	

}
