package com.example.colors.services.impl;

import com.example.colors.services.GreenPrinter;
import org.springframework.stereotype.Component;

@Component
public class SpanishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "verde";
    }
}