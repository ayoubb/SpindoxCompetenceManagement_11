package tn.spindox.server.model.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TechnologyArea {

	private int id_techArea;
	private String name_techArea;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_techArea() {
		return id_techArea;
	}
	public void setId_techArea(int id_techArea) {
		this.id_techArea = id_techArea;
	}
	public String getName_techArea() {
		return name_techArea;
	}
	public void setName_techArea(String name_techArea) {
		this.name_techArea = name_techArea;
	}
	public TechnologyArea( String name_techArea) {
		super();
		this.name_techArea = name_techArea;
	}
	
	
	public TechnologyArea(){
		
	}
	
}
