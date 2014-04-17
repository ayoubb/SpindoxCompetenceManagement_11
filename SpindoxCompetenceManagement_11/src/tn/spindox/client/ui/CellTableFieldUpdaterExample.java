/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package tn.spindox.client.ui;

import java.util.ArrayList;
import java.util.List;

import tn.spindox.client.EmployeeService;
import tn.spindox.client.EmployeeServiceAsync;
import tn.spindox.shared.Employee;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.ProvidesKey;

/**
 * Example of using a {@link FieldUpdater} with a {@link CellTable}.
 */
public class CellTableFieldUpdaterExample /* implements EntryPoint*/ {

	EmployeeServiceAsync serverPerson = GWT.create(EmployeeService.class);

	  
  /**
   * A simple data type that represents a contact with a unique ID.
   */
  private static class Person {
    //private static int nextId = 0;

    private final int id;
    private boolean selected;
    private String firstName;
	private String lastName;
	private String birthDate;
	private String region;
	private String email;
	
	
    public Person(boolean selected, int id_person, String firstName, String lastName, String birthDate, String region, String email) {
      // nextId++;
      this.id = id_person;
      this.selected = selected;
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthDate = birthDate;
      this.region = region;
      this.email = email;
    }
  }

 
  /**
   * The key provider that allows us to identify Contacts even if a field
   * changes. We identify contacts by their unique ID.
   */
  private static final ProvidesKey<Person> KEY_PROVIDER =
      new ProvidesKey<CellTableFieldUpdaterExample.Person>() {
        @Override
        public Object getKey(Person item) {
          return item.id;
        }
      };


    public CellTable<Person> getTable() {
    	 
	    // Create a CellTable with a key provider.
	    final CellTable<Person> table = new CellTable<Person>(KEY_PROVIDER);
	    table.setWidth("100%", false);
	
	    
	      
	    
	    // Add a date column to show the birthday.
	    CheckboxCell  checkBoxCell = new CheckboxCell();
	    Column<Person, Boolean> SelectedColumn = new Column<Person, Boolean>(checkBoxCell) {
	      @Override
	      public Boolean getValue(Person object) {
	        return object.selected;
	      }
	    };
	    
	    TextColumn<Person> firstNameColumn = new TextColumn<Person>() {
	      @Override
	      public String getValue(Person object) {
	        // Return the name as the value of this column.
	        return object.firstName;
	      }
	    };
	    TextColumn<Person> lastNameColumn = new TextColumn<Person>() {
	        @Override
	        public String getValue(Person object) {
	          // Return the name as the value of this column.
	          return object.lastName;
	        }
	      };
	      TextColumn<Person> birthDateColumn = new TextColumn<Person>() {
	      @Override
	      public String getValue(Person object) {
	        // Return the name as the value of this column.
	        return object.birthDate;
	      }
	    };
	    TextColumn<Person> RegionColumn = new TextColumn<Person>() {
	        @Override
	        public String getValue(Person object) {
	          // Return the name as the value of this column.
	          return object.region;
	        }
	    };        
	    TextColumn<Person> emailColumn = new TextColumn<Person>() {
	        @Override
	        public String getValue(Person object) {
	          // Return the name as the value of this column.
	          return object.email;
	        }
	    }; 
	    
	    // Add a field updater to be notified when the user enters a new name.
	    SelectedColumn.setFieldUpdater(new FieldUpdater<Person, Boolean>() {

			@Override
			public void update(int index, Person person, Boolean value) {

				if (value)
				{
					person.selected = true;
				}
				else
				{
					person.selected = false;
				}
			}

	    });
	    
	    
	    ButtonCell  editCell = new ButtonCell();
	    Column<Person, String> editColumn = new Column<Person, String>(editCell) {
	      @Override
	      public String getValue(Person object) {
	        return "edit";
	      }
	    };
	    
	    editColumn.setFieldUpdater(new FieldUpdater<Person, String>() {

			@Override
			public void update(int index, Person object, String value) {

				System.out.println("-----------> clicked");

				callLoginDialogBox();
			}

			protected void callLoginDialogBox() {
				EditPersonBox editPersonBox = new EditPersonBox();

				editPersonBox.show();
			}

	      });
	
	    ButtonCell  deleteCell = new ButtonCell();
	    Column<Person, String> deleteColumn = new Column<Person, String>(deleteCell) {
	      @Override
	      public String getValue(Person object) {
	        return "delete";
	      }
	    };
	    
	    deleteColumn.setFieldUpdater(new FieldUpdater<Person, String>() {

			@Override
			public void update(int index, Person person, String value) {

				System.out.println("-----------> delete clicked");
				
				 	Employee e = new Employee();
				 	e.setId_pers(person.id);
				 	e.setFirstName(person.firstName);
				 	e.setLastName(person.lastName);
				 	e.setBirthDate(person.birthDate);
				 	e.setRegion(person.region);
				 	e.setEmail(person.email);
				 	
				 	
					serverPerson.delete(e, new AsyncCallback<Void>(){

					@Override
					public void onFailure(Throwable caught) {
						System.out.println("---> Error while deleting employee");
					}

					@Override
					public void onSuccess(Void result) {
						System.out.println("---> deleting success !!! ");
						table.redraw();
					}
					
				});
		        	  
			}


	      });	    
	    
	    table.addColumn(SelectedColumn, "");
	    table.addColumn(firstNameColumn, "First Name");
	    table.addColumn(lastNameColumn, "Last Name");
	    table.addColumn(birthDateColumn, "Birth Date");
	    table.addColumn(RegionColumn, "Region");
	    table.addColumn(emailColumn, "Email");
	    table.addColumn(editColumn, "");
	    table.addColumn(deleteColumn, "");
	    	
	    // Push the data into the widget.
	    // table.setRowData(CONTACTS);
	    
		final EmployeeServiceAsync server = GWT.create(EmployeeService.class);
		server.getListEmployees(new AsyncCallback<List<Employee>>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("---> Pb in retrieveing persons...");
				
			}

			@Override
			public void onSuccess(List<Employee> result) {

				List<Person> persons = new ArrayList<Person>();
				
				for(Employee e : result)
				{
					Person contact = new Person(false, e.getId_pers(), e.getLastName(), e.getFirstName(), e.getBirthDate(), e.getRegion(), e.getEmail());
					persons.add(contact);
				}
			     // Push the data into the widget.
			     table.setRowData(persons);
			}
			
		});	
		
		return table;
  }
}