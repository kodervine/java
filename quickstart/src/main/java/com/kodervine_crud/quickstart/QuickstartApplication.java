package com.kodervine_crud.quickstart;

import com.kodervine_crud.quickstart.services.ColorPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
@Log
public class QuickstartApplication implements CommandLineRunner {
	private ColorPrinter colorPrinter;

	public QuickstartApplication(ColorPrinter colorPrinter){
		this.colorPrinter = colorPrinter;
	}

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}
 @Override
	public void run(final String... args) {
		log.info(colorPrinter.print());
 }
}
