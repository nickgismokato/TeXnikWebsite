package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Text;

@Route(value = "Storage", layout = MainView.class)
@PageTitle("Storage Category")
public class StorageView extends VerticalLayout{
	private Text pageName;

	public StorageView(){
		pageName = new Text("StorageView");
		add(pageName);
	}

}
