package com.nickgismokato.TeXnik.ui;

import com.nickgismokato.TeXnik.ui.View.*;
import com.vaadin.flow.component.*;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import com.nickgismokato.TeXnik.Service.*;
import com.nickgismokato.TeXnik.backend.Data.ItemHandler;


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
@Route("/main")
@CssImport(value = "./styles/navbarStyles.css", themeFor = "vaadin-app-layout")
public class MainView extends AppLayout{

    public MainView(GreetService service) {
		DrawerToggle toggle = new DrawerToggle();
		SideNavMenu sideMenu = new SideNavMenu();
		Scroller scroller = new Scroller(sideMenu);
		scroller.setClassName(LumoUtility.Padding.SMALL);

		addToDrawer(scroller);

		HorizontalLayout navigation = getNavigation();
		navigation.getElement();
		addToNavbar(toggle, navigation);

		setPrimarySection(Section.DRAWER);

		//addAttachListener(e -> getUI().ifPresent(ui -> ui.navigate(DashboardView.class)));
    }

	private HorizontalLayout getNavigation(){
		HorizontalLayout navigation = new HorizontalLayout();
		Image satyrLogo = new Image("images/Satyr.png", "Satyr logo");

		H1 title = new H1("TeXnik Website");
		title.getStyle().set("font-size", "var(--lumo-font-size-xl)")
				.set("margin", "0");
		satyrLogo.setWidth(80, Unit.PIXELS);
		satyrLogo.setHeight(47, Unit.PIXELS);
		navigation.addClassNames(LumoUtility.JustifyContent.CENTER,
				LumoUtility.Gap.SMALL, LumoUtility.Height.MEDIUM,
				LumoUtility.Width.FULL);
		navigation.add(title);
		navigation.add (satyrLogo);
		satyrLogo.getStyle().set("margin-left", "auto");
		return navigation;
	}

}
