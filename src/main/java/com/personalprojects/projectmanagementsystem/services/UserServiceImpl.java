package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.personalprojects.projectmanagementsystem.models.User;
import com.personalprojects.projectmanagementsystem.repositories.UserRepository;
import com.personalprojects.projectmanagementsystem.views.ProblemCountByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
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

    @Autowired
    private HelperFunctions helperFunctions;

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

    @Override
    public List<ProblemCountByUsername> getProblemCountByUsername()
    {
        List<ProblemCountByUsername> count = userRepository.getProblemCountByUsername();
        return count;
    }

    @Transactional
    @Override
    public User save(User user)
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userRepository.findById(user.getUserid())
                .orElseThrow(() -> new ResourceNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }
        newUser.setUsername(user.getUsername());
        newUser.setUserrole(user.getUserrole());
        newUser.setEmail(user.getEmail());
        newUser.setPasswordNoEncrypt(user.getPassword());

        return userRepository.save(newUser);
    }

    @Override
    public User update(User user, long id)
    {
        User currentuser = findUserById(id);

        if (helperFunctions.isAuthorizedToMakeChange(currentuser.getUsername()))
        {
            if (user.getUsername() != null)
            {
                currentuser.setUsername(user.getUsername());
            }
            if (user.getUserrole() != null)
            {
                currentuser.setUserrole(user.getUserrole());
            }
            if (user.getEmail() != null)
            {
                currentuser.setEmail(user.getEmail());
            }
            return userRepository.save(currentuser);
        } else
        {
            throw new OAuth2AccessDeniedException();
        }
    }
}
