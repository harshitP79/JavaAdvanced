package com.CaseStudy.LibraryManagememnt.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

    private int id;
    @NotBlank(message = "Name should not be blank")
    @Size(min = 3,message = "The min size should be greater than 3")
    private String name;
    @Email(message = "Must be a valid format")
    private String email;

    @Size(min = 6,message = "Passowrd should be greater than 6 characters")
    private String password;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public  User(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
