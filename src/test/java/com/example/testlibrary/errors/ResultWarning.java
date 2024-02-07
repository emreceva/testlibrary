package com.example.testlibrary.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultWarning {

    NON_DIGIT_ERROR("Please enter an integer");

    private final String error;
}
