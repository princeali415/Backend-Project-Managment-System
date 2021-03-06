package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.ValidationError;

import java.util.List;

public interface HelperFunctions
{

    /**
     * Searches to see if the exception has any constraint violations to report
     *
     * @param cause the exception to search
     * @return constraint violations formatted for sending to the client
     */
    List<ValidationError> getConstraintViolation(Throwable cause);
    /**
     * Checks to see if the authenticated user has access to modify the requested user's information
     *
     * @param username The user name of the user whose data is requested to be changed. This should either match the authenticated user
     *                 or the authenticate must have the role ADMIN
     * @return true if the user can make the modifications, otherwise an exception is thrown
     */
    boolean isAuthorizedToMakeChange(String username);

}
