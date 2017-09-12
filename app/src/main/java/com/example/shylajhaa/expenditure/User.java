package com.example.shylajhaa.expenditure;

/**
 * Created by Shylajhaa on 26-06-2017.
 */

public class User {

    String id;
    String firstName;
    String lastName;
    String email;
    String password;
    String confirmPassword;

    public User(String id, String firstName, String lastName, String email, String password, String confirmPassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}
