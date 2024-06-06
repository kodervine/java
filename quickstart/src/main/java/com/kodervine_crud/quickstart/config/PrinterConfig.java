package com.kodervine_crud.quickstart.config;

import com.kodervine_crud.quickstart.services.BluePrinter;
import com.kodervine_crud.quickstart.services.ColorPrinter;
import com.kodervine_crud.quickstart.services.GreenPrinter;
import com.kodervine_crud.quickstart.services.RedPrinter;
import com.kodervine_crud.quickstart.services.impl.ColorPrinterImpl;
import com.kodervine_crud.quickstart.services.impl.EnglishBluePrinter;
import com.kodervine_crud.quickstart.services.impl.EnglishGreenPrinter;
import com.kodervine_crud.quickstart.services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {
    @Bean
    public BluePrinter bluePrinter(){
        return new EnglishBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new EnglishRedPrinter();
    }

    @Bean
    public GreenPrinter greenPrinter() {
        return new EnglishGreenPrinter();
    }

    @Bean
    public ColorPrinter colorPrinter(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        return new ColorPrinterImpl(redPrinter, bluePrinter, greenPrinter);
    }
}
