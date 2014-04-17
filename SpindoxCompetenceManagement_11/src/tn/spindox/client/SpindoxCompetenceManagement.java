package tn.spindox.client;

import tn.spindox.client.ui.CellTableFieldUpdaterExample;
import tn.spindox.client.ui.HeaderForAllPages;
import tn.spindox.client.ui.Label;
import tn.spindox.client.ui.TabBarExample;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SpindoxCompetenceManagement implements EntryPoint {

//	MenuBarExample menuBarExample = new MenuBarExample();
	private HeaderForAllPages headerAllPages = new HeaderForAllPages();
	Label l = new Label();
	CellTableFieldUpdaterExample table = new CellTableFieldUpdaterExample();

	@Override
	public void onModuleLoad() {
		
		RootPanel.get().add(l.getEmptyLabel());
		RootPanel.get().add(l.getEmptyLabel());

		
		// RootPanel.get().add(headerAllPages);
		 
		TabBarExample tab = new TabBarExample(); 
		RootPanel.get().add(tab.onModuleLoad());
		
		RootPanel.get().add(l.getEmptyLabel());
		RootPanel.get().add(l.getEmptyLabel());

		
		RootPanel.get().add(table.getTable());
		
		
	}


}
