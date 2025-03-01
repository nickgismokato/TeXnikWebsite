package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.nickgismokato.TeXnik.backend.Data.Item;
import com.nickgismokato.TeXnik.backend.Data.ItemHandler;
import com.nickgismokato.TeXnik.backend.Data.Repo.ItemRepository;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


import java.util.ArrayList;
import java.util.List;

@Route(value = "Item", layout = MainView.class)
@PageTitle("Item")
public class ItemView extends VerticalLayout{
	private Html pageName;
	private Html topText;
	private final ItemRepository repo;

	final Grid<Item> itemGrid;

	public ItemView(ItemRepository repo){
		
		pageName = new Html("<h1>ItemView</h1>");
		pageName.getElement().getStyle().set("align", "center");
		topText = new Html("<p>This is just a test of functionality with the <code>grid</code> system provided by <b>Vaadin</b>.<br>Furthermore this also test the custom object <code>Object::Item</code> and <code>Object::ItemHandler</code>.</p>");
		
		this.repo = repo;
		this.itemGrid = new Grid<>(Item.class);

		add(pageName);
		add(topText);
		add(itemGrid);
		insertGrid();
	}

	private void insertGrid(){
		itemGrid.setItems(repo.findAll());
	}
}
