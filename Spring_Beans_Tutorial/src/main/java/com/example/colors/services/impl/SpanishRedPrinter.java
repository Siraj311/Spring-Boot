package com.example.colors.services.impl;

import com.example.colors.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class SpanishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "rojo";
    }
}
