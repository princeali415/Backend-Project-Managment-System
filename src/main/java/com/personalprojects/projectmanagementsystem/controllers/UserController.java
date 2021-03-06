package com.personalprojects.projectmanagementsystem.controllers;

import com.personalprojects.projectmanagementsystem.models.User;
import com.personalprojects.projectmanagementsystem.services.UserService;
import com.personalprojects.projectmanagementsystem.views.ProblemCountByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> listAllUsers()
    {
        List<User> userList = userService.findAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    // Get user by userid
    // http://localhost:2019/users/user/{userid}
    @GetMapping(value = "/user/{userid}", produces = "application/json")
    public ResponseEntity<?> findUserById(@PathVariable long userid)
    {
        User user = userService.findUserById(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Get user by username
    @GetMapping(value = "/user/name/{username}", produces = "application/json")
    public ResponseEntity<?> getUserByName(@PathVariable String username)
    {
        User u = userService.findByName(username);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // Get problem counts by username grouped by userid
    @GetMapping(value = "/problems", produces = "application/json")
    public ResponseEntity<?> getProblemCountByUsername()
    {
        List<ProblemCountByUsername> myList = userService.getProblemCountByUsername();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // PUT Request
    // Given the user id update the user obj
    @PutMapping(value = "/user/{userid}", consumes = "application/json")
    public ResponseEntity<?> updateFullUser(@Valid @RequestBody User updateUser, @PathVariable long userid)
    {
        updateUser.setUserid(userid);
        userService.save(updateUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PATCH Request
    // Updates user record associated with the given id with provided data
    @PatchMapping(value = "/user/{userid}", consumes = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody User updateUser, @PathVariable long userid)
    {
        userService.update(updateUser, userid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DELETE Request
    // Given user id, delete user
    @DeleteMapping(value = "/user/{userid}")
    public ResponseEntity<?> deleteUserById(@PathVariable long userid)
    {
        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
