package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.User;

import java.util.List;

public interface UserService
{
    public String createUser(User user);
    public String updateUser(int userId ,User user);
    public String deleteUser(int userId);
    public User getUser(int userId);
    public List<User> getAllUsers();
}
