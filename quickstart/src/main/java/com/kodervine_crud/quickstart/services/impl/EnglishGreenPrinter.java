package com.kodervine_crud.quickstart.services.impl;

import com.kodervine_crud.quickstart.services.GreenPrinter;
import org.springframework.stereotype.Component;

public class EnglishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "English Green printer";
    }
}
