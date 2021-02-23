package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.User;

import java.util.List;

public interface UserService
{
    public User save(User user);

    List<User> findAllUsers(); // get all users

    User findUserById(long userid); // get user by id
}
