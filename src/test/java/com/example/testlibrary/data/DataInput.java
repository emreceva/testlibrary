package com.example.testlibrary.data;

import com.example.testlibrary.enums.CategoryMenuItem;
import com.example.testlibrary.enums.HeaderItemAuto360;
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

    @ParameterType(value = ENUM_REGEX, name = "headerMenuAuto360")
    public HeaderItemAuto360 headerMenuItemAuto360(String headerMenuAuto360) {
        return HeaderItemAuto360.valueOf(headerMenuAuto360);
    }
}
