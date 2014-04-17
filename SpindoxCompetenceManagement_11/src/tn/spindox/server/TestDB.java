package tn.spindox.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.ejb.QueryHints;

import tn.spindox.server.model.dao.impl.GenericDaoImpl;
import tn.spindox.server.model.jpa.Competence;
import tn.spindox.server.model.jpa.Person;
import tn.spindox.server.model.jpa.Technology;
import tn.spindox.server.model.jpa.TechnologyArea;

public class TestDB {

	public static void main(String[] args) {
		Person person=new Person("hamdi", "baccara","01/01/1556", "tunis","");
		TechnologyArea tech_area=new TechnologyArea("Mobile");
		Technology tech=new Technology("android", tech_area);
		Competence comp=new Competence(person, tech, 7, 2009, 3);
		//person.setId_pers(2);
		
		GenericDaoImpl dao = new GenericDaoImpl();
		dao.create(person);
		dao.create(tech_area);
		dao.create(tech);
		dao.create(comp);
		
//		GenericDaoImpl dao = new GenericDaoImpl();
		/*tech_area.setId_techArea(6);
		dao.delete(tech_area);*/
		//dao.create(tech_area);
		
		/*dao.create(tech_area);
		dao.create(tech);
		dao.create(comp);
		*/ 
		
		// List<Object> result ;
		/* Competence comp = (Competence)result;
		 System.out.println(comp.getPerson().getFirstName() + " " + comp.getTech().getName_tech());*/
		
//		
//		 String sqlWhereRequest =  "where obj.seniority > 1"
//								+ "			 and obj.last_worked_year > 2010"
//								+ "			 and obj.expertise >1";
//		 List<Object> result  = dao.findByCriterias(sqlWhereRequest,Competence.class);
//		 for (Object oneResult : result) {
//			 Competence comp = (Competence)oneResult;
//			 System.out.println(comp.getPerson().getFirstName() + " " + comp.getTech().getName_tech());
//		}
		 
//		String request = "select comp from Competence comp"
//				+ "			 where comp.seniority > 1"
//				+ "			 and comp.last_worked_year > 2010"
//				+ "			 and comp.expertise >1";
		 

	}

}
