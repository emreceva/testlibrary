package com.example.testlibrary.data;

import com.example.testlibrary.enums.CategoryMenuItem;
import io.cucumber.java.ParameterType;

public class DataInput {

    private static final String ENUM_REGEX = "\\b([A-Z_0-9][,\\s][A-Z_0-9]+)\\b";

    @ParameterType(value = ENUM_REGEX, name = "userType")
    public UserType userType(String userType) {
        return UserType.valueOf(userType.toUpperCase());
    }

    @ParameterType(value = ENUM_REGEX, name = "categoryMenuItem")
    public CategoryMenuItem categoryMenuItem(String categoryMenuItem) {
        return CategoryMenuItem.valueOf(categoryMenuItem);
    }
}
