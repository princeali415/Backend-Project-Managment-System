package com.personalprojects.projectmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "problem", allowSetters = true)
    private List<Problem> problems = new ArrayList<>();

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

    public List<Problem> getProblems()
    {
        return problems;
    }

    public void setProblems(List<Problem> problems)
    {
        this.problems = problems;
    }
}
