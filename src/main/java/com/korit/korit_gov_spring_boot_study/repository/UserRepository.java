package com.korit.korit_gov_spring_boot_study.repository;

import com.korit.korit_gov_spring_boot_study.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private List<User> userList;

    private UserRepository() {
        userList = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public User findUserByUsername(String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public void addUser(User user) {
        user.setUserId(userList.size() + 1);
        userList.add(user);
    }
}
