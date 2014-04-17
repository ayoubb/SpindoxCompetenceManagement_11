package tn.spindox.server.model.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Competence {
	
	
	private int id_comp;
	private int seniority;
	private int last_worked_year;
	private int expertise;
	private Technology tech=new Technology();
	private Person person=new Person();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_comp() {
		return id_comp;
	}
	public void setId_comp(int id_comp) {
		this.id_comp = id_comp;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public int getLast_worked_year() {
		return last_worked_year;
	}
	public void setLast_worked_year(int last_worked_year) {
		this.last_worked_year = last_worked_year;
	}
	public int getExpertise() {
		return expertise;
	}
	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}
	
	@OneToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@OneToOne
	public Technology getTech() {
		return tech;
	}
	public void setTech(Technology tech) {
		this.tech = tech;
	}
	
	public Competence( Person person, Technology tech, int seniority, int last_worked_year, int expertise) {
		super();
		this.person = person;
		this.tech = tech;
		this.seniority = seniority;
		this.last_worked_year = last_worked_year;
		this.expertise = expertise;
	}
	
	public Competence(){
		
	}
	
	
}
