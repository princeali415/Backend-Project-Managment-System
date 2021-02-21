package com.personalprojects.projectmanagementsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "problemtypes")
public class ProblemType
{
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long problemtypeid;

    private String problemtype;

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
}
