package com.example.testlibrary.data;


import lombok.Getter;

public enum UserType {

    VALID_USER() {
        @Override
        public User getInfo() {
            User user = new User();
            user.setUsername("tbeta265@gmail.com");
            user.setPassword("test12345.");
            return user;
        }
    };

    public abstract User getInfo();
}
