package tn.spindox.shared;

import java.io.Serializable;

import tn.spindox.server.model.jpa.Person;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6345694670088094001L;
	private int id_pers;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String region;
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public Employee(int id_pers, String firstName, String lastName,
			String birthDate, String region, String email) {
		super();
		this.id_pers = id_pers;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.region = region;
		this.email = email;
	}
	
	public Employee() {
		super();
	}
	
	public Employee(Person p)
	{
		this.id_pers = p.getId_pers();
		this.firstName = p.getFirstName();
		this.lastName = p.getLastName();
		this.birthDate = p.getBirthDate();
		this.region = p.getRegion();
		this.email = p.getEmail();
	}
	

}
