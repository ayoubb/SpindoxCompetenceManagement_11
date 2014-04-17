package tn.spindox.client.ui;


import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditPersonBox extends DialogBox {

	private AsyncCallback<Boolean> caller;
	private Grid editPerson;
	TextBox firstName = new TextBox();
	TextBox lastName = new TextBox();
	TextBox birthOfDate = new TextBox();
	TextBox region = new TextBox();
	TextBox email = new TextBox();
	Button ok = new Button("Enter");
	
	public EditPersonBox() {
		int w = 500;
		int h = 500;
        setAnimationEnabled(true);
        setGlassEnabled(true);
        int left = (Window.getClientWidth() - w)/ 2;
		int top = (Window.getClientHeight() - h)/ 2;
		setPopupPosition(left, top);

		setText("Edit Person");
		
        VerticalPanel panel = new VerticalPanel();
        panel.setHeight("" + h);
        panel.setWidth("" + w);
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        Grid grid = createCreateContent();
        panel.add(grid);

        setWidget(panel);
        
        
	}
		private Grid createCreateContent() {
			  Grid grid = new Grid(7, 2);
			  
			  grid.setText(0, 0, "First Name:");
			  grid.setWidget(0, 1, firstName);
			  
			  grid.setText(1, 0, "Last Name:");
			  grid.setWidget(1, 1, lastName);
			  
			  grid.setText(2, 0, "Date Of Birth:");
			  grid.setWidget(2, 1, birthOfDate);
			  
			  grid.setText(3, 0, "Email:");
			  grid.setWidget(3, 1, email);
			  
			  grid.setText(4, 0, "Region:");
			  grid.setWidget(4, 1, region);
			  
			  grid.setText(5, 0, "");
			  grid.setText(5, 1, "");
			  
			  grid.setText(6, 0, "");   
			  grid.setWidget(6, 1, ok);
			return grid;
			  
/*		firstName = new TextBox();
		firstName.setText("");

		lastName = new TextBox();
		lastName.setText("");

		birthOfDate = new TextBox();
		birthOfDate.setText("");
		
		region = new TextBox();
		region.setText("");
		
		email = new TextBox();
		email.setText("");
		*/
        
     /*   ok.addClickHandler(new ClickHandler() {
           public void onClick(ClickEvent event) {
        	   callLogin();
        	   EditPersonBox.this.hide();
           }
        });*/

/*        Label label = new Label("Please login");

        VerticalPanel panel = new VerticalPanel();
        panel.setHeight("" + h);
        panel.setWidth("" + w);
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.add(label);
        panel.add(user);
        panel.add(password);
        panel.add(ok);

        setWidget(panel);*/
  


	}
}
