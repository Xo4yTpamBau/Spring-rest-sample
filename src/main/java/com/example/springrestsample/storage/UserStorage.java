package com.example.springrestsample.storage;

import com.example.springrestsample.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public List<User> getAll() {
        return users;
    }

    public boolean updateName(int id, String name) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(name);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean containsById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<User> findAllByName(String name) {
        List<User> all = new ArrayList<>();
        for (User user : users) {
            if (user.getName().equals(name)) {
                all.add(user);
            }
        }
        return all;
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
