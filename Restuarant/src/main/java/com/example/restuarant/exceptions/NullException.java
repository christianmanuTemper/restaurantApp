package com.example.restuarant.exceptions;

import com.example.restuarant.entity.Product;
import com.example.restuarant.entity.Request;

import java.text.MessageFormat;

public class NullException extends RuntimeException{

    public NullException(String message) {
        super(message);
    }
}