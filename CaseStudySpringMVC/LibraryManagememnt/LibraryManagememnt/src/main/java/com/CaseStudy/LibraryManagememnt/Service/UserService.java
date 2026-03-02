package com.CaseStudy.LibraryManagememnt.Service;

import com.CaseStudy.LibraryManagememnt.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private  List<User> users = new ArrayList<>();

    public void registerUser(User user){
        users.add(user);
    }

    public  boolean validateUser(String email, String password){
        return users.stream()
                .anyMatch(user -> user.getEmail().equals(email)
                && user.getPassword().equals(password));
    }
}
