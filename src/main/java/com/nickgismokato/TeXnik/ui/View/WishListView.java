package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Wishlist", layout = MainView.class)
@PageTitle("Wishlist")
public class WishListView extends VerticalLayout{
	private Text pageName;

	public WishListView(){
		pageName = new Text("WishListView");
		add(pageName);
	}
}
