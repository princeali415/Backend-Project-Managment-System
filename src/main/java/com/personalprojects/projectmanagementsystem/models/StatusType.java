package com.personalprojects.projectmanagementsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "statustypes")
public class StatusType
{
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long statustypeid;

    private String status;

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
}
