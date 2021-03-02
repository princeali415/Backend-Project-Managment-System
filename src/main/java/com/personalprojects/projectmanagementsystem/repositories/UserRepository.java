package com.personalprojects.projectmanagementsystem.repositories;

import com.personalprojects.projectmanagementsystem.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    /**
     * Find a user based off over username
     *
     * @param username the name (String) of user you seek
     * @return the first user object with the name you seek
     */
    User findByUsername(String username);
}
