package com.kodervine_crud.quickstart.services.impl;

import com.kodervine_crud.quickstart.services.GreenPrinter;
import org.springframework.stereotype.Component;

@Component
public class SpanishGreenPrinter implements GreenPrinter {
 @Override
 public String print() {
     return "Green Hola amigos";
 }
}
