package com.example.theiaprototype;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    public static ArrayList<User> users;

    private String mFullName;
    private String mEmail;
    private String mPassword;

    public User(String fullName, String email, String password) {
        mFullName = fullName;
        mEmail = email;
        mPassword = password;
    }

    public static void addUser(String fullName, String email, String password) {
        User user = new User(fullName, email, password);
        users.add(user);
    }

    public static User getUser(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).mEmail == email) return users.get(i);
        }
        return null;
    }

    public boolean doCredentialsMatch(String email, String password) {
        if (mEmail == email && mPassword == password) return true;
        return false;
    }
}
