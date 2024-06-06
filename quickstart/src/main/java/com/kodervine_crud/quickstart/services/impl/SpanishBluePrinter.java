package com.kodervine_crud.quickstart.services.impl;

import com.kodervine_crud.quickstart.services.BluePrinter;
import org.springframework.stereotype.Component;

@Component
public class SpanishBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "Blue hola amigos";
    }
}
