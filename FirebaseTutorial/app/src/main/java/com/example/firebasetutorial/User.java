package com.example.firebasetutorial;

public class User {
    private String userName;
    private String email;

    public User() {

    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "" +
                "userName='" + getUserName() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
