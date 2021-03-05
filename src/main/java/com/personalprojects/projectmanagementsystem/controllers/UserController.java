package com.personalprojects.projectmanagementsystem.controllers;

import com.personalprojects.projectmanagementsystem.models.User;
import com.personalprojects.projectmanagementsystem.services.UserService;
import com.personalprojects.projectmanagementsystem.views.ProblemCountByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService; 

    // GET REQUEST'S
    // Get all users
    // http://localhost:2019/users/users
    @GetMapping(value = "/users", produces = "application/json") //Not working 500 error
    public ResponseEntity<?> listAllUsers()
    {
        List<User> userList = userService.findAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    // Get user by userid
    // http://localhost:2019/users/user/{userid} // not working need to fix, 500 internal server error
    @GetMapping(value = "/user/{userid}", produces = "application/json")
    public ResponseEntity<?> findUserById(@PathVariable long userid)
    {
        User user = userService.findUserById(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Get problem counts by username grouped by userid
    @GetMapping(value = "/problems", produces = "application/json")
    public ResponseEntity<?> getProblemCountByUsername()
    {
        List<ProblemCountByUsername> myList = userService.getProblemCountByUsername();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
