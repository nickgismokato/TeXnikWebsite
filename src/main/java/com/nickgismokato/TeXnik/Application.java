package com.nickgismokato.TeXnik;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@PWA(name = "TeXnik Webapplication for itemizer", shortName = "TeXnik Website")
@Theme(value = "my-theme", variant = "dark")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void configurePage(AppShellSettings settings){
		settings.addMetaTag("author", "Nickgismokato");
        settings.addFavIcon("icon", "icons/favicon.ico", "128x128");
    }
}
