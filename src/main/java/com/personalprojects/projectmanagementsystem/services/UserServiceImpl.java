package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.User;
import com.personalprojects.projectmanagementsystem.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userServices")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    @Override
    public User save(User user)
    {
        return usersRepository.save(user);
    }

    @Override
    public List<User> findAllUsers()
    {
        List<User> userList = new ArrayList<>();
        usersRepository.findAll().iterator().forEachRemaining(userList::add);

        return userList;
    }

    @Override
    public User findUserById(long userid)
    {
        User user = usersRepository.findById(userid)
            .orElseThrow(() -> new EntityNotFoundException("User " + userid + " Not Found"));

        return user;
    }

}
