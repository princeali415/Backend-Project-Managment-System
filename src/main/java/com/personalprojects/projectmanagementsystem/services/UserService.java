package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.User;
import com.personalprojects.projectmanagementsystem.views.ProblemCountByUsername;

import java.util.List;

public interface UserService
{

    List<User> findAllUsers(); // get all users

    User findUserById(long userid); // get user by id

    /**
     * Returns the user with the given name
     *
     * @param name The full name (String) of the User you seek.
     * @return The User with the given name or throws an exception if not found.
     */
    User findByName(String name);

    List<ProblemCountByUsername> getProblemCountByUsername();
}
