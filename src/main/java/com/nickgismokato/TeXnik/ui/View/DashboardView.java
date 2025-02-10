package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import com.nickgismokato.TeXnik.backend.Data.ItemHandler;

@Route(value="Dashboard", layout = MainView.class)
@PageTitle("Dashboard View")
@RouteAlias(value = "", layout = MainView.class)
public class DashboardView extends VerticalLayout{
	private Text pageName;

	public DashboardView(){
		pageName = new Text("Dashboard");
		add(pageName);
	}
}
