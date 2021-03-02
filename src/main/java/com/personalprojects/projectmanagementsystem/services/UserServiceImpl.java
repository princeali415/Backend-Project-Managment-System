package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.personalprojects.projectmanagementsystem.models.User;
import com.personalprojects.projectmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userServices")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAllUsers()
    {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(userList::add);

        return userList;
    }

    @Override
    public User findUserById(long userid)
    {
        User user = userRepository.findById(userid)
            .orElseThrow(() -> new ResourceNotFoundException("User " + userid + " Not Found"));

        return user;
    }

    @Override
    public User findByName(String name)
    {
        User uu = userRepository.findByUsername(name);
        if (uu == null)
        {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

}
