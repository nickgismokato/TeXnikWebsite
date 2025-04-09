package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.nickgismokato.TeXnik.backend.Data.Item;
import com.nickgismokato.TeXnik.backend.Data.Repo.ItemRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Item", layout = MainView.class)
@PageTitle("Item")
public class ItemView extends VerticalLayout {
    private final ItemRepository repo;
    private final Grid<Item> itemGrid;
    private final TextField nameField;
    private final TextField eanField;
    private final TextField amountField;

    public ItemView(ItemRepository repo) {
        this.repo = repo;
        this.itemGrid = new Grid<>(Item.class);

        // Page title and description
        add(new Label("Item Management"));
        add(new Div(new Label("Add, view, and delete items.")));

        // Form for adding items
        nameField = new TextField("Name");
        eanField = new TextField("EAN");
        amountField = new TextField("Amount");
        Button addButton = new Button("Add Item", e -> addItem());
        HorizontalLayout formLayout = new HorizontalLayout(nameField, eanField, amountField, addButton);
        add(formLayout);

        // Grid for displaying items
        itemGrid.setColumns("id", "name", "EAN", "amount");
        itemGrid.setItems(repo.findAll());
        add(itemGrid);

        // Delete button
        Button deleteButton = new Button("Delete Selected", e -> deleteSelectedItem());
        add(deleteButton);
    }

    private void addItem() {
        try {
            String name = nameField.getValue();
            int ean = Integer.parseInt(eanField.getValue());
            int amount = Integer.parseInt(amountField.getValue());

            Item newItem = new Item(0, 0, ean, name, amount); // Adjust constructor parameters as needed
            repo.save(newItem);

            itemGrid.setItems(repo.findAll()); // Refresh grid
            clearForm();
        } catch (NumberFormatException ex) {
            // Handle invalid input
            add(new Label("Invalid input. Please check your values."));
        }
    }

    private void deleteSelectedItem() {
        Item selected = itemGrid.asSingleSelect().getValue();
        if (selected != null) {
            repo.delete(selected);
            itemGrid.setItems(repo.findAll()); // Refresh grid
        }
    }

    private void clearForm() {
        nameField.clear();
        eanField.clear();
        amountField.clear();
    }
}