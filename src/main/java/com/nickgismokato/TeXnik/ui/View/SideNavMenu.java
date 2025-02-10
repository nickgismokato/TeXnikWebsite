package com.nickgismokato.TeXnik.ui.View;

import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;


public class SideNavMenu extends SideNav{
		public SideNavMenu(){
			this.addItem(
					new SideNavItem("Dashboard", "Dashboard",VaadinIcon.DASHBOARD.create()),
					new SideNavItem("Item", "Item", VaadinIcon.TABLE.create()),
					new SideNavItem("Storage Category", "Storage", VaadinIcon.STORAGE.create()),
					new SideNavItem("Wishlist", "Wishlist", VaadinIcon.GIFT.create())
			);
		}
}
