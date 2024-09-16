package com.example.testlibrary.data;

public enum UserType {

    VALID_USER() {
        @Override
        public User getInfo() {
            User user1 = new User();
            user1.setUsername("tbeta265@gmail.com");
            user1.setPassword("test12345.");
            return user1;
        }
    };

    public abstract User getInfo();
}
