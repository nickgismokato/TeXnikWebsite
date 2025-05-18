package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import io.swagger.v3.oas.models.links.Link;


@Route(value = "About", layout = MainView.class)
public class AboutView extends Div{
	public AboutView() {
		Html pageTitle = new Html("<h1>About</h1>");
		pageTitle.getStyle().set("text-align", "center");
		add(pageTitle);
		

		VerticalLayout aboutUs = new VerticalLayout();
		aboutUs.setAlignItems(FlexComponent.Alignment.CENTER);

	
		

		Html devName = new Html("<p><b>Name:</b> Nick Alexander Villum Laursen</p>");
		Html githubName = new Html("<p><b>Github link:</bZ <a href=\"https://github.com/nickgismokato\" target=\"_blank\"> Github</a></p>");
		//githubName.setTarget("_blank");
		Html devMail = new Html("<p><b>Email:</b> nickvillumlaursen@gmail.com</p>");
		VerticalLayout developerInformation = new VerticalLayout(devName, githubName, devMail);
		developerInformation.setSpacing(false);
		developerInformation.setPadding(false);

		Details devDetails = new Details("Developer Information", developerInformation);
		devDetails.setSizeFull();
		devDetails.setOpened(true);
		devDetails.addThemeVariants(DetailsVariant.FILLED);


		Html webpageInformation = new Html("<p><b>Webpage Titel:</b> TeXnik</p>");
		Html webpageLicence = new Html("<p><b>Webpage Licence:</b> MIT</p>");
		Html webpageDescription = new Html("<p><b>Webpage Description:</b> TeXnik is a web application for managing and tracking items for our storage. It provides an easy-to-use interface for adding, viewing, and deleting items, as well as generating reports and charts to visualize data. Furthermore the Site contains a user system for managing the people having access to the site and the backend. The development progress can be found on GitHub and also the source code.</p>");
		Html webpageGithubLink = new Html("<p><b>Webpage GitHub link:</b> <a href=\"https://github.com/nickgismokato/TeXnikWebsite/tree/main\" target=\"_blank\"> Github</a></p>");
		VerticalLayout webpageInformationLayout = new VerticalLayout(webpageInformation, webpageLicence, webpageDescription, webpageGithubLink);
		webpageInformationLayout.setSpacing(false);
		webpageInformationLayout.setPadding(false);
		Details webpageDetails = new Details("Webpage Information", webpageInformationLayout);
		webpageDetails.setSizeFull();
		webpageDetails.setOpened(false);
		webpageDetails.addThemeVariants(DetailsVariant.FILLED);

		aboutUs.add(devDetails, webpageDetails);
		add(aboutUs);

		
	}
}
