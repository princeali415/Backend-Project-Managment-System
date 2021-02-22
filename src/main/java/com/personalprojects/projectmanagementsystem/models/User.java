package com.personalprojects.projectmanagementsystem.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User extends Auditable
{
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    private String username;

    /**
     * A foreign key to role type table
     * Forms a Many-to_one relationship with the roletypes table
     * Many Users to one role type
     * Contains a object pointer to the full roletype object
     */
    @ManyToOne
    @JoinColumn(name = "roletypeid", nullable = false)
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private User user;

    private String email;

    private String password;

    /**
     * List of problems associated with this user. Does not get save in the database
     * Forms a One-to-Many relationship with problems. One user to many problems
     */
    @OneToMany(mappedBy = "userrole", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "userrole", allowSetters = true)
    private List<Problem> problems = new ArrayList<>();

    // Constructors


    public User()
    {
        // required by JPA
    }

    public User(
        String username,
        User user,
        String email,
        String password)
    {
        this.username = username;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Problem> getProblems()
    {
        return problems;
    }

    public void setProblems(List<Problem> problems)
    {
        this.problems = problems;
    }
}
