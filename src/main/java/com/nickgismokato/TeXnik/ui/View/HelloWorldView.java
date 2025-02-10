package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI.*;

@Route(value="hello", layout= MainView.class)
@PageTitle("Hello World")
public class HelloWorldView extends HorizontalLayout{
	private TextField name;
	private Button sayHello;

	public HelloWorldView() {
		setId("hello-world-view");
		name = new TextField("Your name");
		sayHello = new Button("Say hello");
		add(name, sayHello);
		setVerticalComponentAlignment(Alignment.END, name, sayHello);

		// Handle clicks
		sayHello.addClickListener(e -> {
			Notification.show("Hello " + name.getValue(), 1000, Notification.Position.MIDDLE);
		});
	}
}
