package tn.spindox.client;

import java.util.List;

import tn.spindox.server.model.jpa.Person;
import tn.spindox.shared.Employee;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("employees")
public interface EmployeeService extends RemoteService {
  public List<Employee> getListEmployees() throws IllegalArgumentException;
  
  void create(Employee person);
  void delete(Employee person);
  Employee findByCriterias(String sqlWhereRequest);
  Employee findById(int id);
  void update(Employee person);
  
  
}
