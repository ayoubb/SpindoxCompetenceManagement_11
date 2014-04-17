package tn.spindox.server;

import java.util.ArrayList;
import java.util.List;

import tn.spindox.client.EmployeeService;
import tn.spindox.server.model.dao.impl.GenericDaoImpl;
import tn.spindox.server.model.jpa.Person;
import tn.spindox.shared.Employee;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class EmployeeServiceImpl extends RemoteServiceServlet implements  EmployeeService {

	private GenericDaoImpl dao = new GenericDaoImpl();

	@Override
	public List<Employee> getListEmployees() throws IllegalArgumentException {

		// GenericDaoImpl genericDaoImpl = new GenericDaoImpl();
		List<Object> listPerson = dao.findAll(Person.class);
		List<Employee> listEmployee = new ArrayList<>();
		for (Object object : listPerson)
		{
			Person p = (Person)object;
			Employee employee = new Employee(p);
			listEmployee.add(employee);
		}
		
		return listEmployee;
	}

	 @Override
	 public void create(Employee person) {
	  dao.create(person);
	  
	 }

	 @Override
	 public void delete(Employee employee) {
		  Person p = new Person(employee);	 
		  dao.delete(p);
	 }

	 @Override
	 public Employee findByCriterias(String sqlWhereRequest) {
		 Employee person = (Employee) dao.findByCriterias(sqlWhereRequest, Person.class);
		 return person;
	 }
	  
	 @Override
	 public Employee findById(int id) {
		 Employee person = (Employee) dao.findById(id, Person.class);
		 return person;
	 }

	 @Override
	 public void update(Employee person) {
	  Person pers = (Person) dao.findById(person.getId_pers(), Person.class);
	  if (person != null) {
	   dao.update(person);
	      
	   }
	 }

}
