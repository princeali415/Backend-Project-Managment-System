package com.personalprojects.projectmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project extends Auditable
{
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectid;

    @Column(nullable = false, unique = true)
    private String projectname;

    @Column(nullable = false)
    private String projectdescription;

    /**
     * List of problems associated with this project. Does not get save in the database
     * Forms a One-to-Many relationship with Problems. One project to many problems
     */
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "project", allowSetters = true)
    private Set<Problem> problems = new HashSet<>();

    //Constructors

    public Project()
    {
        // Required by JPA
    }

    public Project(
        String projectname,
        String projectdescription)
    {
        this.projectname = projectname;
        this.projectdescription = projectdescription;
    }

    // Getters and Setters


    public long getProjectid()
    {
        return projectid;
    }

    public void setProjectid(long projectid)
    {
        this.projectid = projectid;
    }

    public String getProjectname()
    {
        return projectname;
    }

    public void setProjectname(String projectname)
    {
        this.projectname = projectname;
    }

    public String getProjectdescription()
    {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription)
    {
        this.projectdescription = projectdescription;
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
