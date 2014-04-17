package tn.spindox.server.model.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Technology {

	private int id_tech;
	private String name_tech;
	private TechnologyArea tech_area=new TechnologyArea();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_tech() {
		return id_tech;
	}
	public void setId_tech(int id_tech) {
		this.id_tech = id_tech;
	}
	public String getName_tech() {
		return name_tech;
	}
	public void setName_tech(String name_tech) {
		this.name_tech = name_tech;
	}
	
	
	@ManyToOne
	(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_techArea", nullable = false)
	public TechnologyArea getTech_area() {
		return tech_area;
	}
	public void setTech_area(TechnologyArea tech_area) {
		this.tech_area = tech_area;
	}
	public Technology(String name_tech, TechnologyArea tech_area) {
		super();
		this.name_tech = name_tech;
		this.tech_area = tech_area;
	}
	
	public Technology(){
		
	}
	public Technology(String name_tech2, int i) {
		this.name_tech=name_tech2;
		this.id_tech=i;
	}
}
