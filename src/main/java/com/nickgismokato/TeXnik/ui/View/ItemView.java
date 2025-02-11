package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.nickgismokato.TeXnik.backend.Data.Item;
import com.nickgismokato.TeXnik.backend.Data.ItemHandler;

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

	public ItemView(){
		pageName = new Html("<h1>ItemView</h1>");
		pageName.getElement().getStyle().set("align", "center");
		topText = new Html("<p>This is just a test of functionality with the <code>grid</code> system provided by <b>Vaadin</b>.<br>Furthermore this also test the custom object <code>Object::Item</code> and <code>Object::ItemHandler</code>.</p>");
		ItemHandler.AddToList(1, 0, 125966, "Cable", 20);
		ItemHandler.AddToList(24, 3, 883638983, "Printer", 999);
		ItemHandler.AddToList(112, 4, 0, "Bat", 1);
		Grid<Item> itemGrid = new Grid<>(Item.class, false);
		List<Item> items = ItemHandler.ReturnItemList();
		if(items == null){
			Text error = new Text("items list was null");
		}else{
			itemGrid.setItems(items);
			itemGrid.addColumn(item -> item.getSatyrID()).setHeader("Satyr ID").setSortable(true);
			itemGrid.addColumn(item -> item.getCatID()).setHeader("Category ID").setSortable(true);
			itemGrid.addColumn(item -> item.getEAN()).setHeader("EAN").setSortable(true);
			itemGrid.addColumn(item -> item.getName()).setHeader("Name").setSortable(true);
			itemGrid.addColumn(item -> item.getAmount()).setHeader("Amount").setSortable(true);
			itemGrid.addColumn(item -> item.getStatus()).setHeader("Status").setSortable(true);
			}
		add(pageName);
		add(topText);
		add(itemGrid);
	}
}
