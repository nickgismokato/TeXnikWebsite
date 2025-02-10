package com.nickgismokato.TeXnik.ui;

import com.nickgismokato.TeXnik.ui.View.*;
import com.vaadin.flow.component.*;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;

import com.vaadin.flow.component.html.*;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;


import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.tabs.Tabs;


import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


import com.nickgismokato.TeXnik.Service.*;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.Optional;


/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting th2e user name and a button
 * that shows a greeting message in a notification.
 */
@Route("")
public class MainView extends AppLayout {

    public MainView(GreetService service) {
		H1 title = new H1("TeXnik Website");

		title.getStyle().set("font-size", "var(--lumo-font-size-l)")
				.set("margin", "0");

		DrawerToggle toggle = new DrawerToggle();
		SideNavMenu sideMenu = new SideNavMenu();
		Scroller scroller = new Scroller(sideMenu);
		scroller.setClassName(LumoUtility.Padding.SMALL);

		addToDrawer(scroller);

		HorizontalLayout navigation = getNavigation();
		navigation.getElement();

		addToNavbar(toggle, title, navigation);
    }

	private HorizontalLayout getNavigation(){
		HorizontalLayout navigation = new HorizontalLayout();
		navigation.addClassNames(LumoUtility.JustifyContent.CENTER,
				LumoUtility.Gap.SMALL, LumoUtility.Height.MEDIUM,
				LumoUtility.Width.FULL);
		navigation.add(createLink("HelloWorld"));
		return navigation;
	}

	private RouterLink createLink(String viewName){
		RouterLink link = new RouterLink();
		link.add(viewName);
		link.addClassNames(LumoUtility.Display.FLEX,
			LumoUtility.AlignItems.CENTER,
				LumoUtility.Padding.Horizontal.MEDIUM,
				LumoUtility.TextColor.SECONDARY, LumoUtility.FontWeight.MEDIUM);
		link.getStyle().set("text-decoration", "none");

		return link;
	}
}
