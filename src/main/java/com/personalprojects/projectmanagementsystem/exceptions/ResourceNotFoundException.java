package com.personalprojects.projectmanagementsystem.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super("Error from 8-up PMS Application " + message);
    }
}
