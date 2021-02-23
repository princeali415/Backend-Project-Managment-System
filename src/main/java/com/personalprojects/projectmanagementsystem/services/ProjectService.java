package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.Project;

import java.util.List;

public interface ProjectService
{
    List<Project> findAllProjects(); // get all projects
}
