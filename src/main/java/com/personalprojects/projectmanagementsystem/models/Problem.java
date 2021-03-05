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

    @Column(nullable = false)
    private String problemname;

    @Column(nullable = false)
    private String problemdescription;

    /**
     * A foreign key to problem type table
     * Forms a Many-to_one relationship with the problemtypes table, Many problems to one problem type
     * Contains a object pointer to the full problem type object
     */
    @ManyToOne
    @JoinColumn(name = "problemtypeid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private ProblemType problemtype;

    /**
     * A foreign key to project table
     * Forms a Many-to_one relationship with the projects table, Many problems to one project
     * Contains a object pointer to the full problem object
     */
    @ManyToOne
    @JoinColumn(name = "projectid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private Project project;

    /**
     * A foreign key to user table
     * Forms a Many-to_one relationship with the users table, Many problems to one user
     * Contains a object pointer to the full problem object
     */
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private User user;

    /**
     * A foreign key to status type table
     * Forms a Many-to_one relationship with the status type table, Many problems to one status type
     * Contains a object pointer to the full problem object
     */
    @ManyToOne
    @JoinColumn(name = "statustypeid", nullable = false)
    @JsonIgnoreProperties(value = "problems", allowSetters = true)
    private StatusType status;

    // Constructors


    public Problem()
    {
        //required by JPA
    }

    public Problem(
        String problemname,
        String problemdescription,
        ProblemType problemtype,
        Project project,
        User user,
        StatusType status)
    {
        this.problemname = problemname;
        this.problemdescription = problemdescription;
        this.problemtype = problemtype;
        this.project = project;
        this.user = user;
        this.status = status;
    }

    // getters and setters


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

    public ProblemType getProblemtype()
    {
        return problemtype;
    }

    public void setProblemtype(ProblemType problemtype)
    {
        this.problemtype = problemtype;
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject(Project project)
    {
        this.project = project;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public StatusType getStatus()
    {
        return status;
    }

    public void setStatus(StatusType status)
    {
        this.status = status;
    }

    // add getter for createddate;
}
