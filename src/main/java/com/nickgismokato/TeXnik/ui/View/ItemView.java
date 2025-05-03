package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.nickgismokato.TeXnik.backend.Data.Item;
import com.nickgismokato.TeXnik.backend.Data.Controller.ItemController;
import com.nickgismokato.TeXnik.backend.Data.Enum.CategoryEnum;
import com.nickgismokato.TeXnik.backend.Data.Repo.ItemRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "Item", layout = MainView.class)
@PageTitle("Item")
public class ItemView extends VerticalLayout{
    private final ItemRepository repo;
    private final Grid<Item> itemGrid;
    private final TextField nameField;
    private final TextField eanField;
    private final TextField amountField;
    private final TextField satyrIdField;
    private final Select<CategoryEnum> categorySelect;

    public ItemView(ItemRepository repo){
        this.repo = repo;
        this.itemGrid = new Grid<>(Item.class);

        // Page title and description
        add(new NativeLabel("Item Management"));
        add(new Div(new NativeLabel("Add, view, and delete items.")));

        // Form for adding items
        nameField = new TextField("Name");
        eanField = new TextField("EAN");
        amountField = new TextField("Amount");
        satyrIdField = new TextField("SatyrID");

        // Select component for category
        categorySelect = new Select<>();
        categorySelect.setLabel("Category");
        categorySelect.setItems(CategoryEnum.values());
        categorySelect.setItemLabelGenerator(CategoryEnum::name);
        categorySelect.setPlaceholder("Select a category");

        Button addButton = new Button("Add Item", e -> addItem());
        HorizontalLayout formLayout = new HorizontalLayout(nameField, satyrIdField, eanField, amountField, categorySelect, addButton);
        add(formLayout);

        // Grid for displaying items
        configureGrid();
        add(itemGrid);

        // Delete button
        Button deleteButton = new Button("Delete Selected", e -> deleteSelectedItem());
        add(deleteButton);
    }

	private void configureGrid(){
		// Disable automatic column generation
		itemGrid.setColumns();
	
		// Add specific columns with unique keys and enable sorting
		itemGrid.addColumn(Item::getName)
				.setHeader("Name")
				.setKey("nameColumn")
				.setSortable(true); // Enable sorting
	
		itemGrid.addColumn(Item::getSatyrID)
				.setHeader("Satyr ID")
				.setKey("satyrIdColumn")
				.setSortable(true); // Enable sorting
	
		itemGrid.addColumn(Item::getEAN)
				.setHeader("EAN")
				.setKey("eanColumn")
				.setSortable(true); // Enable sorting
	
		itemGrid.addColumn(Item::getAmount)
				.setHeader("Amount")
				.setKey("amountColumn")
				.setSortable(true); // Enable sorting
	
		itemGrid.addColumn(item -> CategoryEnum.fromInteger(item.getCatID()).name())
				.setHeader("Category")
				.setKey("categoryColumn")
				.setSortable(true); // Enable sorting
	
		// Enable editing
		Binder<Item> binder = new Binder<>(Item.class);
		Editor<Item> editor = itemGrid.getEditor();
		editor.setBinder(binder);
		editor.setBuffered(true);
	
		// Add editor components
		TextField nameEditor = new TextField();
		binder.bind(nameEditor, Item::getName, Item::setName);
		itemGrid.getColumnByKey("nameColumn").setEditorComponent(nameEditor);
	
		TextField satyrIdEditor = new TextField();
		binder.bind(satyrIdEditor, item -> String.valueOf(item.getSatyrID()), (item, value) -> item.setSatyrID(Integer.parseInt(value)));
		itemGrid.getColumnByKey("satyrIdColumn").setEditorComponent(satyrIdEditor);
	
		TextField eanEditor = new TextField();
		binder.bind(eanEditor, item -> String.valueOf(item.getEAN()), (item, value) -> item.setEAN(Long.parseLong(value)));
		itemGrid.getColumnByKey("eanColumn").setEditorComponent(eanEditor);
	
		TextField amountEditor = new TextField();
		binder.bind(amountEditor, item -> String.valueOf(item.getAmount()), (item, value) -> item.setAmount(Integer.parseInt(value)));
		itemGrid.getColumnByKey("amountColumn").setEditorComponent(amountEditor);
	
		// Add Select editor for Category
		Select<CategoryEnum> categoryEditor = new Select<>();
		categoryEditor.setItems(CategoryEnum.values());
		categoryEditor.setItemLabelGenerator(CategoryEnum::name);
		binder.bind(categoryEditor, 
			item -> CategoryEnum.fromInteger(item.getCatID()), 
			(item, value) -> item.setCatID(value.ordinal()));
		itemGrid.getColumnByKey("categoryColumn").setEditorComponent(categoryEditor);
	
		// Handle double-click to edit
		itemGrid.addItemDoubleClickListener(event -> {
			if (editor.isOpen()) {
				editor.cancel(); // Close the editor if it is already open
			}
			editor.editItem(event.getItem());
		});
	
		// Save changes on Enter key
		itemGrid.getElement().addEventListener("keydown", event -> {
			if ("Enter".equals(event.getEventData().getString("event.key"))) {
				editor.save();
			}
		}).addEventData("event.key");
	
		// Save changes on Enter key or when editing is closed
		editor.addSaveListener(event -> {
			try {
				binder.writeBean(event.getItem());
				updateItemInDatabase(event.getItem()); // Use the ItemController to update the item
				itemGrid.getDataProvider().refreshItem(event.getItem());
			} catch (ValidationException e) {
				e.printStackTrace();
			}
		});
	
		editor.addCloseListener(event -> {
			if (editor.isOpen()) {
				try {
					binder.writeBean(event.getItem());
					updateItemInDatabase(event.getItem()); // Use the ItemController to update the item
					itemGrid.getDataProvider().refreshItem(event.getItem());
				} catch (ValidationException e) {
					e.printStackTrace();
				}
			}
		});
	
		// Set items for the grid
		itemGrid.setItems(repo.findAll());
	}

    private void addItem(){
        try{
            String name = nameField.getValue();
            long ean = parseEAN(eanField.getValue(), -1);
            int satyrId = parseOrDefault(satyrIdField.getValue(), -1);
            int amount = Integer.parseInt(amountField.getValue());
            CategoryEnum category = categorySelect.getValue();

            if(category == null){
                add(new NativeLabel("Please select a category."));
                return;
            }

            Item newItem = new Item(satyrId, category.ordinal(), (Long) ean, name, amount);
            repo.save(newItem);

            itemGrid.setItems(repo.findAll());
            clearForm();
        }catch(NumberFormatException ex) {
            add(new NativeLabel("Invalid input. Please check your values."));
        }
    }

	private void updateItemInDatabase(Item item){
		try{
			// Use the injected ItemRepository to update the item
			repo.save(item);
		}catch(Exception e) {
			e.printStackTrace();
			add(new NativeLabel("Failed to update item: " + e.getMessage()));
		}
	}

    private int parseOrDefault(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private long parseEAN(String value, long defaultValue){
        try{
            long parsedValue = Long.parseLong(value);
            if(parsedValue >= 0 && parsedValue <= 9999999999999999L) {
                return parsedValue;
            }else{
                return defaultValue;
            }
        }catch(NumberFormatException e){
            return defaultValue;
        }
    }

    private void deleteSelectedItem(){
        Item selected = itemGrid.asSingleSelect().getValue();
        if(selected != null){
            repo.delete(selected);
            itemGrid.setItems(repo.findAll());
        }
    }

    private void clearForm(){
        nameField.clear();
        eanField.clear();
        amountField.clear();
        satyrIdField.clear();
        categorySelect.clear();
    }
}