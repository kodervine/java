package com.kodervine_crud.quickstart.services.impl;

import com.kodervine_crud.quickstart.services.BluePrinter;
import org.springframework.stereotype.Component;

public class EnglishBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "English blue printer";
    }
}
