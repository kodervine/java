package com.kodervine_crud.quickstart;

import com.kodervine_crud.quickstart.config.PizzaConfig;
import com.kodervine_crud.quickstart.services.ColorPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
@Log
public class QuickstartApplication implements CommandLineRunner {
	final PizzaConfig pizzaConfig;

	public QuickstartApplication(PizzaConfig pizzaConfig) {
		this.pizzaConfig = pizzaConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		log.info(String.format("I want a %s crust pizza with %s and %s sauce",
				pizzaConfig.getCrust(),
				pizzaConfig.getTopping(),
				pizzaConfig.getSauce()));
 }
}
