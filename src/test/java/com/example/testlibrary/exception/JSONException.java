package com.example.testlibrary.exception;

public class JSONException extends RuntimeException{


    public JSONException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
