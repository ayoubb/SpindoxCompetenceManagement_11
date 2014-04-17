package tn.spindox.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class HeaderForAllPages extends Composite {

	private static HeaderForAllPagesUiBinder uiBinder = GWT
			.create(HeaderForAllPagesUiBinder.class);

	interface HeaderForAllPagesUiBinder extends
			UiBinder<Widget, HeaderForAllPages> {
	}

	public HeaderForAllPages() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public HeaderForAllPages(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
