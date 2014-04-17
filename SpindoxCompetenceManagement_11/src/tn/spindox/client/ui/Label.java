package tn.spindox.client.ui;

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HTML;

public class Label {
	
	public HTML getEmptyLabel(){
		
		HTML emptyLabel = new HTML(new SafeHtmlBuilder().appendEscapedLines("\n").toSafeHtml());

		return emptyLabel;
	}

}
