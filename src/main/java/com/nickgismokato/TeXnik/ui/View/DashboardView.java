package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="Dashboard", layout = MainView.class)
@PageTitle("Dashboard View")
public class DashboardView extends VerticalLayout{
	private Text pageName;

	public DashboardView(){
		pageName = new Text("Dashboard");
		add(pageName);
	}
}
