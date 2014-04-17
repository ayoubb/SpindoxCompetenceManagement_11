package tn.spindox.client;

import java.util.List;

import tn.spindox.shared.Employee;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface EmployeeServiceAsync {
  void getListEmployees(AsyncCallback<List<Employee>> callback) throws IllegalArgumentException;
  
  void create(Employee person, AsyncCallback<Void> callback);
  void findById(int id, AsyncCallback<Employee> callback);
  void update(Employee person, AsyncCallback<Void> callback);
  void delete(Employee person, AsyncCallback<Void> callback);
  void findByCriterias(String sqlWhereRequest, AsyncCallback<Employee> callback);  
}
