package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Item", layout = MainView.class)
@PageTitle("Item")
public class ItemView extends VerticalLayout{
	private Text pageName;

	public ItemView(){
		pageName = new Text("ItemView");
		add(pageName);
	}
}
