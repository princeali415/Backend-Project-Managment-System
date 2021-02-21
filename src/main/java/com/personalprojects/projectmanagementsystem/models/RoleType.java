package com.personalprojects.projectmanagementsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "roletypes")
public class RoleType
{
    //Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roletypeid;

    private String roletype;

    // Constructor


    public RoleType()
    {
        // required by JPA
    }

    public RoleType(String roletype)
    {
        this.roletype = roletype;
    }

    // Getters and Setters


    public long getRoletypeid()
    {
        return roletypeid;
    }

    public void setRoletypeid(long roletypeid)
    {
        this.roletypeid = roletypeid;
    }

    public String getRoletype()
    {
        return roletype;
    }

    public void setRoletype(String roletype)
    {
        this.roletype = roletype;
    }
}
