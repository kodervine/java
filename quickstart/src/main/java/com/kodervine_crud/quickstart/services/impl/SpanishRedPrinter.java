package com.kodervine_crud.quickstart.services.impl;

import com.kodervine_crud.quickstart.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class SpanishRedPrinter implements RedPrinter {
    @Override
    public String print(){
        return "Red Hola amigos";
    }
}
