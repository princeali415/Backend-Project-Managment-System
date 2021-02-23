package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.Project;
import com.personalprojects.projectmanagementsystem.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "projectService")
public class ProjectServiceImpl implements ProjectService
{
    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public List<Project> findAllProjects()
    {
        List<Project> projectList = new ArrayList<>();
        projectsRepository.findAll().iterator().forEachRemaining(projectList::add);

        return projectList;
    }
}
