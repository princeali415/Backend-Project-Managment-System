package com.personalprojects.projectmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "problems")
public class Problem extends Auditable
{
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long problemid;

    private String problemname;

    private String problemdescription;

    /**
     * A foreign key to problem type table
     * Forms a Many-to_one relationship with the problemtypes table, Many problems to one problem type
     * Contains a object pointer to the full problem type object
     */
    @ManyToOne
    @JoinColumn(name = "problemtypeid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private Problem problemtype;

    /**
     * A foreign key to project table
     * Forms a Many-to_one relationship with the projects table, Many problems to one project
     * Contains a object pointer to the full problem object
     */
    @ManyToOne
    @JoinColumn(name = "projectid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private Problem project;

    /**
     * A foreign key to user table
     * Forms a Many-to_one relationship with the users table, Many problems to one user
     * Contains a object pointer to the full problem object
     */
    @ManyToOne
    @JoinColumn(name = "projectmanagerid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private Problem projectmanager;

    /**
     * A foreign key to user table
     * Forms a Many-to_one relationship with the users table, Many problems to one user
     * Contains a object pointer to the full problem object
     */
    @ManyToOne
    @JoinColumn(name = "developerid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private Problem developer;

    /**
     * A foreign key to status type table
     * Forms a Many-to_one relationship with the status type table, Many problems to one status type
     * Contains a object pointer to the full problem object
     */
    @ManyToOne
    @JoinColumn(name = "statustypeid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private Problem status;

    // Constructors


    public Problem()
    {
        //required by JPA
    }

    public Problem(
        String problemname,
        String problemdescription,
        Problem problemtype,
        Problem project,
        Problem projectmanager,
        Problem developer,
        Problem status)
    {
        this.problemname = problemname;
        this.problemdescription = problemdescription;
        this.problemtype = problemtype;
        this.project = project;
        this.projectmanager = projectmanager;
        this.developer = developer;
        this.status = status;
    }

    // Getters and Setters


    public long getProblemid()
    {
        return problemid;
    }

    public void setProblemid(long problemid)
    {
        this.problemid = problemid;
    }

    public String getProblemname()
    {
        return problemname;
    }

    public void setProblemname(String problemname)
    {
        this.problemname = problemname;
    }

    public String getProblemdescription()
    {
        return problemdescription;
    }

    public void setProblemdescription(String problemdescription)
    {
        this.problemdescription = problemdescription;
    }

    public Problem getProblemtype()
    {
        return problemtype;
    }

    public void setProblemtype(Problem problemtype)
    {
        this.problemtype = problemtype;
    }

    public Problem getProject()
    {
        return project;
    }

    public void setProject(Problem project)
    {
        this.project = project;
    }

    public Problem getProjectmanager()
    {
        return projectmanager;
    }

    public void setProjectmanager(Problem projectmanager)
    {
        this.projectmanager = projectmanager;
    }

    public Problem getDeveloper()
    {
        return developer;
    }

    public void setDeveloper(Problem developer)
    {
        this.developer = developer;
    }

    public Problem getStatus()
    {
        return status;
    }

    public void setStatus(Problem status)
    {
        this.status = status;
    }
}
