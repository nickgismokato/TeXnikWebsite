package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
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

		Accordion accordion = new Accordion();

                Span devName = new Span("Name: Nick Alexander Villum Laursen");
                Html githubName = new Html("<p>Github link: <a href=\"https://github.com/nickgismokato\" target=\"_blank\"> Github</a></p>");
                //githubName.setTarget("_blank");
                Span devMail = new Span("Email: nickvillumlaursen@gmail.com");
                VerticalLayout developerInformation = new VerticalLayout(devName, githubName, devMail);
                developerInformation.setSpacing(false);
                developerInformation.setPadding(false);
                AccordionPanel devopPanel = accordion.add("Developer Information", developerInformation);
                devopPanel.addThemeVariants(DetailsVariant.FILLED);



                

                Span street = new Span("4027 Amber Lake Canyon");
                Span zipCode = new Span("72333-5884 Cozy Nook");
                Span city = new Span("Arkansas");

                VerticalLayout billingAddressLayout = new VerticalLayout();
                billingAddressLayout.setSpacing(false);
                billingAddressLayout.setPadding(false);
                billingAddressLayout.add(street, zipCode, city);

                AccordionPanel billingAddressPanel = accordion.add("Billing address",
                        billingAddressLayout);
                billingAddressPanel.addThemeVariants(DetailsVariant.FILLED);

                Span cardBrand = new Span("Mastercard");
                Span cardNumber = new Span("1234 5678 9012 3456");
                Span expiryDate = new Span("Expires 06/21");

                VerticalLayout paymentLayout = new VerticalLayout();
                paymentLayout.setSpacing(false);
                paymentLayout.setPadding(false);
                paymentLayout.add(cardBrand, cardNumber, expiryDate);

                AccordionPanel paymentPanel = accordion.add("Payment", paymentLayout);
                paymentPanel.addThemeVariants(DetailsVariant.FILLED);

		accordion.setSizeFull();
		aboutUs.add(accordion);
		add(aboutUs);
	}
}
