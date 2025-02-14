package com.nickgismokato.TeXnik.ui.View;

import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.charts.model.Side;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class SideNavMenu extends VerticalLayout{
		public SideNavMenu(){

			SideNav sideNavMain = new SideNav();
			sideNavMain.addItem(
					new SideNavItem("Dashboard", "Dashboard",VaadinIcon.DASHBOARD.create()),
					new SideNavItem("Item", "Item", VaadinIcon.TABLE.create()),
					new SideNavItem("Storage Category", "Storage", VaadinIcon.STORAGE.create()),
					new SideNavItem("Wishlist", "Wishlist", VaadinIcon.GIFT.create())
			);
			SideNav sideNavBottom = new SideNav();
			sideNavBottom.addItem(
				new SideNavItem("About", "About", VaadinIcon.QUESTION_CIRCLE_O.create())
			);
			add(sideNavMain, sideNavBottom);
		}
}
