package com.personalprojects.projectmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "statustypes")
public class StatusType
{
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long statustypeid;

    private String status;

    /**
     * List of problems associated with this status type. Does not get save in the database
     * Forms a One-to-Many relationship with Problems. One status type to many problems
     */
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "status", allowSetters = true)
    private Set<Problem> problems = new HashSet<>();

    // Constructor

    public StatusType()
    {
        // Required by JPA
    }

    public StatusType(String status)
    {
        this.status = status;
    }

    // Getters and Setters


    public long getStatustypeid()
    {
        return statustypeid;
    }

    public void setStatustypeid(long statustypeid)
    {
        this.statustypeid = statustypeid;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Set<Problem> getProblems()
    {
        return problems;
    }

    public void setProblems(Set<Problem> problems)
    {
        this.problems = problems;
    }
}
