package com.kodervine_crud.quickstart.services.impl;

import com.kodervine_crud.quickstart.services.BluePrinter;
import com.kodervine_crud.quickstart.services.GreenPrinter;
import com.kodervine_crud.quickstart.services.RedPrinter;
import com.kodervine_crud.quickstart.services.ColorPrinter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ColorPrinterImpl implements ColorPrinter {
    private RedPrinter redPrinter;

    private BluePrinter bluePrinter;

    private GreenPrinter greenPrinter;

    public ColorPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }

    @Override
    public String print(){
        return String.join(",", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}
