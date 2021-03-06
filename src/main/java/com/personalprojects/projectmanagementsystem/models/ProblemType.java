package com.personalprojects.projectmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "problemtypes")
public class ProblemType
{
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long problemtypeid;

    private String problemtype;

    /**
     * List of problems associated with this problemtype. Does not get saved in the database
     * Forms a One-to-Many relationship with Problems. One problem type to many problems
     */
    @OneToMany(mappedBy = "problemtype", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "problemtype", allowSetters = true)
    private Set<Problem> problems = new HashSet<>();  // this needs to be set or list?

    // Constructors


    public ProblemType()
    {
        // required by JPA
    }

    public ProblemType(String problemtype)
    {
        this.problemtype = problemtype;
    }

    // Getters and Setters


    public long getProblemtypeid()
    {
        return problemtypeid;
    }

    public void setProblemtypeid(long problemtypeid)
    {
        this.problemtypeid = problemtypeid;
    }

    public String getProblemtype()
    {
        return problemtype;
    }

    public void setProblemtype(String problemtype)
    {
        this.problemtype = problemtype;
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
