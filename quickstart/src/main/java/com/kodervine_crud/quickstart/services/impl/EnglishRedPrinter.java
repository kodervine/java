package com.kodervine_crud.quickstart.services.impl;

import com.kodervine_crud.quickstart.services.RedPrinter;
import org.springframework.stereotype.Component;

public class EnglishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "English Red printer";
    }
}
